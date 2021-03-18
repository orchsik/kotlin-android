package com.orchsik.helloactivity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.orchsik.helloactivity.databinding.ActivityObject2Binding

class ActivityObject2: AppCompatActivity() {
    private lateinit var binding: ActivityObject2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityObject2Binding.inflate(layoutInflater)
        val view  = binding.root
        setContentView(view)

        val obj1 = intent.getParcelableExtra<ParcelableObj>("obj1")
        binding.textView2.text = ""
        binding.textView2.append("obj1.data1 : ${obj1?.data1}\n")
        binding.textView2.append("obj1.data1 : ${obj1?.data2}\n")

        binding.button2.setOnClickListener {
            val t2 = ParcelableObj();
            t2.data1 = 200
            t2.data2 = "string2"

            val result_intent = Intent()
            result_intent.putExtra("obj2", t2)

            setResult(RESULT_OK, result_intent)

            finish()
        }
    }
}