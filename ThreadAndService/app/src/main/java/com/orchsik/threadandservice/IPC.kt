package com.orchsik.threadandservice

import android.app.ActivityManager
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Build
import android.os.Bundle
import android.os.IBinder
import androidx.appcompat.app.AppCompatActivity
import com.orchsik.threadandservice.databinding.IPCBinding

/**
 * Activity에서 실행중인 서비스를 제어하거나 데이터를 사용하는 등의 작업이 필요할 때 사용하는 개념
 * 현재 실행중인 서비스에 접속하고 서비스가 가지고 있는 메서드를 호출할 수 있는 개념
 * 이 때, 데이터를 반환 받아 사용할 수 있다.
 */
class IPC : AppCompatActivity() {

    // 접속한 서비스 객체
    var ipcService:IPCService? = null

    // 서비스 접속을 관리하는 객체
    private val connection = object : ServiceConnection {
        // 서비스 접속 성공했을 때, 서비스의 onBind 메서드가 반환하는 객체를 받는다.
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            // 서비스 추출
            val binder = service as IPCService.LocalBinder
            ipcService = binder.getService()
        }

        // 서비스 접속 해제했을 때
        override fun onServiceDisconnected(name: ComponentName?) {
            ipcService = null
        }
    }

    private lateinit var binding: IPCBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = IPCBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // 서비스가 가동중이 아니면 가동한다.
        val serviceIntent = Intent(this, IPCService::class.java)
        val check = isServiceRunning("com.orchsik.threadandservice.IPCService")
        if(!check) {
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                startForegroundService(serviceIntent)
            } else {
                startService(serviceIntent)
            }
        }

        // 서비스에 접속한다.
        bindService(serviceIntent, connection, Context.BIND_AUTO_CREATE)

        binding.button.setOnClickListener {
            val value = ipcService?.getNumber()
            binding.textView.text = "value: $value"
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        // 접속 서비스를 접속 해제
        unbindService(connection)
    }

    // 서비스 실행 여부 검사
    private fun isServiceRunning(name:String):Boolean {
        // 현재 실행중인 서비스를 가져온다
        val activityManager = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        val serviceInfoList = activityManager.getRunningServices(Int.MAX_VALUE)

        // 서비스의 이름이 원하는 이름인가
        for (serviceInfo in serviceInfoList) {
            if (serviceInfo.service.className == name) {
                return true
            }
        }
        return false
    }


}