package com.orchsik.helloactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.orchsik.helloactivity.databinding.ActivityData2Binding

class ActivityData2 : AppCompatActivity() {
    private lateinit var binding: ActivityData2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityData2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // 현재 Activity를 실행하기 위해 사용할 Intent로부터 데이터를 추출한다.
        val data1 = intent.getIntExtra("data1", 0)
        val data2 = intent.getDoubleExtra("data1", 0.0)
        val data3 = intent.getBooleanExtra("data1", false)
        val data4 = intent.getStringExtra("data1")

        binding.textView2.text = ""
        binding.textView2.append("data1: $data1\n")
        binding.textView2.append("data2: $data2\n")
        binding.textView2.append("data3: $data3\n")
        binding.textView2.append("data4: $data4\n")

        binding.button2.setOnClickListener {
            val result_intent = Intent()
            result_intent.putExtra("value1", 200)
            result_intent.putExtra("value2", 22.22)
            result_intent.putExtra("value3", false)
            result_intent.putExtra("value4", "string2")

            setResult(RESULT_OK, result_intent)

            finish()
        }
    }
}