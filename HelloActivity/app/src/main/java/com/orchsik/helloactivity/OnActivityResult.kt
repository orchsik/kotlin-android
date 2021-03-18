package com.orchsik.helloactivity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.orchsik.helloactivity.databinding.ActivityFirstBinding

/**
 * startActivityForResult
 * Activity에서 다른 Activity를 실행하고 다시 돌아왔을 때,
 * 어떤 처리가 필요한 경우 사용
 */
class OnActivityResult : AppCompatActivity() {

    private val SECOND_ACTIVITY = 200
    private val THIRD_ACTIVITY = 300

    private lateinit var binding: ActivityFirstBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.button.setOnClickListener {
            val second_intent = Intent(this, OnActivityResult2::class.java)
            startActivityForResult(second_intent, SECOND_ACTIVITY)
        }

        binding.button4.setOnClickListener {
            val third_intent = Intent(this, OnActivityResult3::class.java)
            startActivityForResult(third_intent, THIRD_ACTIVITY)
        }
    }

    /**
     * requestCode: startActivityForResult 메서드의 2번재 인자값
     * resultCode: setResult 메서드의 인자값
     */
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        // binding.textView.text = "comback from other activity."
        when(requestCode) {
            SECOND_ACTIVITY -> {
                binding.textView.text = "SecondActivity에서 돌아왔습니다."
            }
            THIRD_ACTIVITY -> {
                binding.textView.text = "ThirdActivity에서 돌아왔습니다.\n"
                when(resultCode) {
                    Activity.RESULT_OK -> {
                        binding.textView.append("result: OK")
                    }
                    Activity.RESULT_CANCELED -> {
                        binding.textView.append("result: Canceled")
                    }
                    Activity.RESULT_FIRST_USER -> {
                        binding.textView.append("result: User1")
                    }
                    Activity.RESULT_FIRST_USER +1 -> {
                        binding.textView.append("result: User2")
                    }
                }
            }
        }
    }
}