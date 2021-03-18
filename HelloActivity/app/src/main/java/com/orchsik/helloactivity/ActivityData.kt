package com.orchsik.helloactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.orchsik.helloactivity.databinding.ActivityDataBinding

/**
 * Activity를 실행하기 위해 사용하는 Intent 객체에 데이터를 저장할 수 있다.
 * putExtra 메서드를 통해 데이터 저장이 가능하며 데이터가 저장된 Intent는 실행되는 Activity까지 전달된다.
 * 이를 통해 Intent에 저장된 데이터를 추출할 수 있다.
 * Intent는 Activity를 종료하고 돌아갈 때도 전달할 수 있다.
 * 전달된 Intent에 저장된 데이터는 get{자료형}Extra 메서드를 통해 추출할 수 있다.
 */
class ActivityData : AppCompatActivity() {

    private val SECOND_ACTIVITY = 2

    private lateinit var binding: ActivityDataBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDataBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.button.setOnClickListener {
            val second_intent = Intent(this, ActivityData2::class.java)

            second_intent.putExtra("data1", 100)
            second_intent.putExtra("data2", 11.11)
            second_intent.putExtra("data3", true)
            second_intent.putExtra("data4", "string1")

            // startActivity(second_intent)
            startActivityForResult(second_intent, SECOND_ACTIVITY)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == SECOND_ACTIVITY) {
            when(resultCode) {
                RESULT_OK -> {
                    val value1 = data?.getIntExtra("value1", 0)
                    val value2 = data?.getDoubleExtra("value2", 0.0)
                    val value3 = data?.getBooleanExtra("value3", false)
                    val value4 = data?.getStringExtra("value4")

                    binding.textView.text = ""
                    binding.textView.append("value1: $value1\n")
                    binding.textView.append("value2: $value2\n")
                    binding.textView.append("value3: $value3\n")
                    binding.textView.append("value4: $value4\n")
                }
            }
        }
    }
}