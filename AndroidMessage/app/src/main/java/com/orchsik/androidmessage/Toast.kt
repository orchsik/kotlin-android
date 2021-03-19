package com.orchsik.androidmessage

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import com.orchsik.androidmessage.databinding.CustomToastBinding
import com.orchsik.androidmessage.databinding.ToastBinding

class Toast : AppCompatActivity() {
    private lateinit var binding: ToastBinding
    private lateinit var customToastBinding: CustomToastBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ToastBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.button.setOnClickListener {
            // Toast 객체 생성
            val t1 = Toast.makeText(this, "Basic Toast", Toast.LENGTH_SHORT)

            // calback 객체 생성
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                val callback = object : Toast.Callback() {
                    override fun onToastHidden() {
                        super.onToastHidden()
                        binding.textView.text = "Toast Message is hidden."
                    }

                    override fun onToastShown() {
                        super.onToastShown()
                        binding.textView.text = "Toast Message is shown"
                    }
                }
                t1.addCallback(callback)
            }

            t1.show()
        }

        binding.button2.setOnClickListener {
            // Toast에 보여줄 View 생성
            customToastBinding = CustomToastBinding.inflate(layoutInflater)
            val toastView = customToastBinding.root
            // val toastView = layoutInflater.inflate(R.layout.custom_toast, null)

            customToastBinding.run {
                toastImage.setImageResource(R.drawable.img_android)
                toastText.text = "This is custom toast"
            }

            toastView.setBackgroundResource(android.R.drawable.toast_frame)

            // Toast 객체 생성
            val t1 = Toast(this)
            // View 설정
            t1.view = toastView
            // Toast 위치 조정
            t1.setGravity(Gravity.CENTER, 0, 0)
            // Toast 노출시간
            t1.duration = Toast.LENGTH_SHORT

            t1.show()
        }

    }
}