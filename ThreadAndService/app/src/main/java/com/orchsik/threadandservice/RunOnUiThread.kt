package com.orchsik.threadandservice

import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.orchsik.threadandservice.databinding.RunOnUiThreadBinding
import java.lang.Thread
import kotlin.concurrent.thread

/**
 * RunOnUiThread 메서드는 개발자가 발생시킨 일반 쓰레드에서
 * 코드 일부를 MainThread가 처리하도록 하는 메서드이다.
 * 이를 이용해 Handler 대신하여 Thread를 운영할 수 있다.
 */
class RunOnUiThread : AppCompatActivity() {
    var isRunning = false;

    private lateinit var binding: RunOnUiThreadBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = RunOnUiThreadBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        binding.button.setOnClickListener {
            val now = System.currentTimeMillis()
            binding.textView.text = "button click: $now"
        }

        isRunning = true
        thread {
            while(isRunning) {
                SystemClock.sleep(5000)
                val now = System.currentTimeMillis()
                Log.d("test", "thread: $now")

                /*
                // 낮은 버전에서는 에러
                binding.textView2.text = "thread: $now"
                */

                /*
                runOnUiThread(object : Thread() {
                    override fun run() {
                        super.run()
                        binding.textView2.text = "thread: $now"
                    }
                })
                */
                runOnUiThread {
                    binding.textView2.text = "runOnUiThread: $now"
                }
                SystemClock.sleep(5000)
                runOnUiThread(object : Thread() {
                    override fun run() {
                        super.run()
                        binding.textView2.text = "another work"
                    }
                })
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        isRunning = false;
    }
}