package com.orchsik.threadandservice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.SystemClock
import com.orchsik.threadandservice.databinding.HandlerBinding
import java.lang.Thread

class Handler : AppCompatActivity() {
    private lateinit var binding: HandlerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = HandlerBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.button.setOnClickListener {
            val now = System.currentTimeMillis()
            binding.textView.text = "now: ${now}"
        }

        /*
        // MainThread에서 이런 반복 작업하면 안 댐.
       while (true) {
           SystemClock.sleep(100)
           val now2 = System.currentTimeMillis()
           binding.textView2.text = "while statement: $now2"
       }
       */

        /**
         * handler 사용.
         * MainThread에서 처리하기 때문에 5초 미만의 작업만.
         */
        val handler = Handler(Looper.myLooper()!!)
        // 한번의 작업단위 구현
        val thread1 = object : Thread() {
            override fun run() {
                super.run()
                val now2 = System.currentTimeMillis()
                binding.textView2.text = "handler: $now2"

                // handler.post(this)
                handler.postDelayed(this, 1000)
            }
        }
        // handler.post(thread1)
        handler.postDelayed(thread1, 1000)


    }


}