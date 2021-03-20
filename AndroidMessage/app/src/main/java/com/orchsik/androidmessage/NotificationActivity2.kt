package com.orchsik.androidmessage

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.orchsik.androidmessage.databinding.NotificationActivity2Binding

class NotificationActivity2 : AppCompatActivity(){
    private lateinit var binding: NotificationActivity2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = NotificationActivity2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

    }
}