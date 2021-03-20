package com.orchsik.threadandservice

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.orchsik.threadandservice.databinding.ServiceBinding

/**
 * Service ?
 * 안드로이드 4대 구성요소 중 하나로 백그라운드 처리를 위해 제공되는 요소.
 * Activity는 화면을 가지고 있어 화면이 보이는 동안 동작하지만
 * Service는 화면을 가지고 있지 않아 보이지 않는 동안에도 동작하는 것을 의미.
 *
 * 8.0 버전 이상 부터 Service는 백그라운드에서 운영되는 실행요소로써 메모리 부족, 절전모드 등 다양한 상황에서
 * OS에 의해 제거될 수 있다.
 * 이를 방지하고자 할 때는 Foreground Service로 만들어 사용하면 된다.
 * Foreground Service외의 서비스는 OS에 의해 모두 제거될 수 있다.
 * Foreground Service의 목적은 현재 단말기에서 Service를 통해 백그라운드에서 작업중이라는 것을
 * 사용자에게 알리는 목적으로 사용한다.
 */
class Service : AppCompatActivity() {
    private lateinit var binding: ServiceBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ServiceBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val serviceIntent = Intent(this, TestService::class.java)

        binding.button.setOnClickListener {
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                startForegroundService(serviceIntent)
            } else {
                startService(serviceIntent)
            }
        }

        binding.button2.setOnClickListener {
            stopService(serviceIntent)
        }
    }
}