package com.orchsik.threadandservice

import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.orchsik.threadandservice.databinding.BrApp1Binding

/**
 * BroadCastReceiver는 OS에서 특정 상황에 발생하는 메시지를 받아들여 동작하는 실행단위다.
 * BoradCastReceiver는 반드시 외부에서 접근하기 위한 이름을 가져와야 한다.
 *
 * 애플리케이션이 설치되면 OS는 BroadCastReceiver에 등록된 이름으로 정리하여 목록화 한다.
 * OS에서 어떤 사건이 발생하면 사건과 관련된 이름으로 지정된 BroadCastReceiver를 찾아 동작시킨다.
 * 애플리케이션에서 이름을 전달하여 실행을 요청하면 해당 이름이 지정된 BroadCastReceiver를 찾아 동작시킨다.
 *
 * BroadCastReceiver는 평소에는 동작하지 않다가 동작 요청이 발생하면 동작한다.
 * 동작 요청은 이름을 통해 요청할 수 있으며, intent filter를 통해 이름을 등록한다.
 */
class BRApp : AppCompatActivity() {

    private val br = TestReceiver()

    private lateinit var binding: BrApp1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = BrApp1Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // 8.0 이상 부터는 코드를 통해 등록하고 해제해야 한다.
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val filter = IntentFilter("kr.co.orchsik.testbr")
            registerReceiver(br, filter)
        }

        binding.button.setOnClickListener {
            // val brIntent1 = Intent(this, TestReceiver::class.java)
            val brIntent1 = Intent("kr.co.orchsik.testbr")
            sendBroadcast(brIntent1)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            unregisterReceiver(br)
        }
    }
}