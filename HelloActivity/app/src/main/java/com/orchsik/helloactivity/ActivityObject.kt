package com.orchsik.helloactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.orchsik.helloactivity.databinding.ActivityObject1Binding

/**
 * Intent를 통해 객체를 전달할 때는 객체 직렬화를 해야 하는데 안드로이드는 Parcelabel 인터페이스 사용.
 * Parcelabel 인터페이스는 전달 받은 쪽에서 객체를 복원할 때 필요한 정보를 가진 부분을 의미.
 */
class ActivityObject : AppCompatActivity() {
    val SECOND_ACTIVITY = 200

    private lateinit var binding: ActivityObject1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityObject1Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.button.setOnClickListener {
            val second_intent = Intent(this, ActivityObject2::class.java)

            val t1 = ParcelableObj()
            t1.data1 = 100
            t1.data2 = "string1"

            second_intent.putExtra("obj1", t1)

            // startActivity(second_intent)
            startActivityForResult(second_intent, SECOND_ACTIVITY)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == SECOND_ACTIVITY) {
            if(resultCode == RESULT_OK) {
                // 객체 추출
                val obj2 = data?.getParcelableExtra<ParcelableObj>("obj2")
                binding.textView.text = ""
                binding.textView.append("obj2.data1: ${obj2?.data1}\n")
                binding.textView.append("obj2.data2: ${obj2?.data2}\n")
            }
        }
    }

}