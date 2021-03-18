package com.orchsik.helloactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.orchsik.helloactivity.databinding.StartActivityBinding

class StartActivity : AppCompatActivity() {
    private lateinit var binding: StartActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = StartActivityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        binding.button.setOnClickListener {
            /**
             * 코틀린 리플렉션 개념.
             * SecondActivity::class.java
             * SecondActivity를 가지고 만들어진 Java파일이 컴파일 된 클래스 파일을 지칭함.
             */
            val second_intent = Intent(this, SecondActivity::class.java)
            startActivity(second_intent)
        }

    }
}