package com.orchsik.helloword

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.hello_button.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hello_button)

        // 버튼에 리스너를 설정한다.
        val button26 = findViewById<Button>(R.id.button26)
        button26.setOnClickListener(listener1)
        /* Kotlin */
        imageButton.setOnClickListener(listener2)
        button27.setOnClickListener(listener3)
        button34.setOnClickListener(listener3)

        /* 고차함수 + lambda */
//        button36.setOnClickListener ({
//            textView2.text = "다섯번재 버튼을 눌렀습니다."
//        })
        button36.setOnClickListener {
            textView2.text = "다섯번재 버튼을 눌렀습니다."
        }

    }

    /* 버튼을 클릭하면 동작하는 리스너 객체 */
    /* OnClickListener 를 구현한 View 클래스의 객체(object)를 생성한 동시에 listener1에 할당 */
//    private val listener1 = object : View.OnClickListener{
//        override fun onClick(p0: View?) {
//            val textView2 = findViewById<TextView>(R.id.textView2)
//            textView2.text = "첫 번째 버튼을 눌렀습니다."
//        }
//    }
    /* convert to lambda */
    private val listener1 = View.OnClickListener { _ ->
        val textView2 = findViewById<TextView>(R.id.textView2)
        textView2.text = "첫 번째 버튼을 눌렀습니다."
    }

    private val listener2 = View.OnClickListener { textView2.text = "두 번째 버튼을 눌렀습니다." }

    /* 하나의 리스너로 button27, 34 분기 처리 */
//    private val listener3 = object : View.OnClickListener {
//        override fun onClick(p0: View?) {
//            when(p0?.id) {
//                R.id.button27 -> {
//                    textView2.text = "세 번째 버튼을 눌렀습니다."
//                }
//                R.id.button34 -> {
//                    textView2.text = "네 번째 버튼을 눌렀습니다."
//                }
//
//            }
//        }
//    }
    private val listener3 = View.OnClickListener { p0 ->
        when(p0?.id) {
            R.id.button27 -> {
                textView2.text = "세 번째 버튼을 눌렀습니다."
            }
            R.id.button34 -> {
                textView2.text = "네 번째 버튼을 눌렀습니다."
            }

        }
    }
}