package com.orchsik.helloactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.orchsik.helloactivity.databinding.ActivitySecondBinding

class StartActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        /**
         * 현재 Activity  종료
         */
        binding.button2.setOnClickListener {
            finish()
        }
    }
}