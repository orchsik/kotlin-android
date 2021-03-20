package com.orchsik.androidmessage

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.orchsik.androidmessage.databinding.NotificationActivity1Binding

class NotificationActivity1 : AppCompatActivity(){
    private lateinit var binding: NotificationActivity1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = NotificationActivity1Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Activity 실행시, 사용한 Intent를 통해 데이터 추출
        var data1 = intent.getIntExtra("data1", 0)
        var data2 = intent.getIntExtra("data2", 0)

        binding.textView.text = "data1 : $data1\n"
        binding.textView.append("data2 : $data2\n")
    }
}