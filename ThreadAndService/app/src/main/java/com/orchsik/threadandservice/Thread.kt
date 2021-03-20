package com.orchsik.threadandservice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import com.orchsik.threadandservice.databinding.ThreadBinding
import java.lang.Thread
import kotlin.concurrent.thread

/**
 * Thread는 여러 처리를 비동기적으로 처리하기 위해 사용한다.
 * 하위 버전의 Android는 비동기적 처리 외에 네트워크에 관련된 코드는 전부 Thread로 운영해야 한다.
 *
 * Android는 Activity의 코드를 처리하기 위해 Thread를 발생시킨다.
 * 이 Thread를 Main Thread(UI Thread)라고 부른다.
 * Main Thread는 터치기능이나 화면 작업을 처리하는데, 유휴 상태일 때만 가능하다.
 * 이 때문에 오래 걸리는 작업은 별도의 Thread를 발생시켜 처리하고 Main Thread를 항상 유효 상태로 유지해야 한다.
 *
 * Main Thread가 아닌 개발자가 발생시킨 Thread에서 화면에 대한 처리를 하면 오류가 발생한다.
 * Android 8.0(api level 26)이상 부터만 개발자가 발생 시킨 Thread에서 화면처리가 가능하다.
 */
class Thread : AppCompatActivity() {
    var isRunning = false

    private lateinit var binding: ThreadBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ThreadBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.button.setOnClickListener {
            val now = System.currentTimeMillis()
            binding.textView.text = "현재시간: $now"
        }

        /**
         * MainThread에서 오래 걸리는 작업 처리시 화면처리가 안됨을 확인할 수 있음
         */
        /*
        var i:Int = 0
        while (i<500) {
            i++
            SystemClock.sleep(100)
            val now2 = System.currentTimeMillis()
            Log.d("test", "while statement: $now2")
        }
        */

        isRunning = true
        /**
         * 코틀린 thread
         */
        thread {
            while (isRunning) {
                SystemClock.sleep(100)
                val now2 = System.currentTimeMillis()
                Log.d("test", "Thread: $now2")
            }
        }

        /**
         * 자바 Thread
         */
        /*
        val thread = object : Thread() {
            override fun run() {
                super.run()
                while (isRunning) {
                    SystemClock.sleep(100)
                    val now2 = System.currentTimeMillis()
                    Log.d("test", "Thread: $now2")
                    binding.textView2.text = "Thread: $now2"
                }
            }
        }
        thread.start()
        */
    }

    override fun onDestroy() {
        super.onDestroy()
        isRunning = false
    }
}