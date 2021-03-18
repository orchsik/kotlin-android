package com.orchsik.helloactivity

import android.Manifest
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.orchsik.helloactivity.databinding.ActivityActionBinding

/**
 * 안드로이드에서 제공되는 기본 애플리케이션 중
 * 다른 애플리케이션이 사용할 수 있도록 제공되는 Activity가 있다.
 * 모두 공개되어 있는 이름이 제공되며 이를 통해 실행할 수 있다.
 */
class ActivityAction : AppCompatActivity() {

    val permissions = arrayOf(Manifest.permission.CALL_PHONE)

    private lateinit var binding: ActivityActionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityActionBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        requestPermissions(permissions, 0)

        binding.button.setOnClickListener {
            val uri = Uri.parse("geo:37.243243,131.861601")
            val intent = Intent(Intent.ACTION_VIEW, uri)

            startActivity(intent)
        }

        binding.button2.setOnClickListener {
            val uri = Uri.parse("https://developer.android.com")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

        binding.button3.setOnClickListener {
            val uri = Uri.parse("tel:12341234123")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

        binding.button4.setOnClickListener {
            val uri = Uri.parse("tel:123412342134")
            val intent = Intent(Intent.ACTION_CALL, uri)
            startActivity(intent)
        }
    }
}