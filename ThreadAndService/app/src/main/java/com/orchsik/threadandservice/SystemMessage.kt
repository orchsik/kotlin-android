package com.orchsik.threadandservice

import android.Manifest
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.orchsik.threadandservice.databinding.SystemMessageBinding

/**
 * 단말기에서 사건이 발생했을 경우 각 사건에 대해 정해진 메시지를 발생시킨다.
 * 메시지가 발생되면 이에 반응하는 BroadCastReceiver들이 동작하게 된다.
 * 개발자가 각 사건에 대한 이름으로 BroadCastReceiver를 등록해 놓으면 OS가 이를 찾아 동작시키는 방식이다.
 * 8.0 이상부터는 사용할 수 있는 시스템 메시지의 수가 줄어들었다.
 */
class SystemMessage : AppCompatActivity() {

    private val permissions = arrayOf(
        Manifest.permission.RECEIVE_BOOT_COMPLETED
        , Manifest.permission.READ_PHONE_STATE
        , Manifest.permission.RECEIVE_SMS
    )

    private lateinit var binding: SystemMessageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SystemMessageBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        requestPermissions(permissions, 0)


    }
}