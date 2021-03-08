package com.orchsik.helloword

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.hello_textview.*

class HelloTextView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hello_textview)


        // 뷰의 주소값을 얻어온다
        val wtext1 = findViewById<TextView>(R.id.wtext1)
        wtext1.text = "안녕하세요."
        wtext2.text = "반갑습니다."
        wtext2.textSize  = 40F

//        wtext2.setBackgroundColor(Color.RED)\
//        wtext2.setBackgroundColor(Color.rgb(100, 100, 200))
        wtext2.setBackgroundColor(Color.argb(100, 100, 200, 100))
        wtext2.setTextColor(Color.BLUE)
        wtext2.append("\nthanks to")
    }
}