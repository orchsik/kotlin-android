package com.orchsik.threadandservice

import android.os.*
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import com.orchsik.threadandservice.databinding.HandlerMessageBinding
import java.lang.Thread
import kotlin.concurrent.thread

/**
 * 네트워크에 관련된 처리나 오래걸리는 작업은 모두 개발자 발생시킨 Thread에서 처리해야한다.
 */
class HandlerMessage : AppCompatActivity() {
    var isRunnig = false

    private lateinit var binding: HandlerMessageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = HandlerMessageBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.button.setOnClickListener {
            val now = System.currentTimeMillis()
            binding.textView.text = "now: $now"
        }


        /*
        // 오래 걸리는 작업을 아래와 같이 할 경우 화면처리가 늦어짐.
        val handler1 = Handler(Looper.myLooper()!!)
        val thread1 = object : Thread() {
            override fun run() {
                super.run()
                SystemClock.sleep(5000)
                val now = System.currentTimeMillis()
                Log.d("test", "now: ${now}")
                binding.textView2.text = "now: ${now}"
                handler1.postDelayed(this, 5000)
            }
        }
        handler1.postDelayed(thread1, 5000)
        */
        /**
         * 화면처리를 위한 handler
         */
        val longTermHandler = object : Handler(Looper.myLooper()!!) {
            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)

                val now3 = System.currentTimeMillis()
                when(msg.what) {
                    0-> {
                        binding.textView2.text = "handler-0: $now3"
                    }
                    1-> {
                        binding.textView2.text = "handler-1: $now3"
                    }
                    2 -> {
                        binding.textView2.text = "handler-2: ${msg.arg1}, ${msg.arg2}"
                    }

                }
            }
        }

        /**
         * 오래걸리는 작업 Thread
         */
        isRunnig = true
        thread {
            while (isRunnig) {
                val now2 = System.currentTimeMillis()
                Log.d("test", "longTerm process: $now2")

                SystemClock.sleep(500)
                longTermHandler.sendEmptyMessage(0)
                SystemClock.sleep(500)
                longTermHandler.sendEmptyMessage(1)
                SystemClock.sleep(500)
                val msg = Message()
                msg.what = 2
                msg.arg1 = 100
                msg.arg2 = 200
                msg.obj = "object"
                longTermHandler.sendMessage(msg)
            }
        }


    }

    override fun onDestroy() {
        super.onDestroy()
        isRunnig = false
    }
}