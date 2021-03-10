package com.orchsik.helloword

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.hello_scrollview.*

class HelloScrollView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hello_scrollview)

//        textView1
//        textView2
//        button1
//        button2
//        sv1
//        hsv1

        button1.setOnClickListener {
            textView1.text = "Y : ${sv1.scrollY}"
            textView2.text = "X : ${hsv1.scrollX}"
        }

        button2.setOnClickListener {
//            지정된 위치로 이동
//            sv1.scrollTo(0, 500)
//            hsv1.scrollTo(500, 0)
//            지정된 위치로 이동 + 애니메이션
//            sv1.smoothScrollTo(0, 500)
//            hsv1.smoothScrollTo(500,0)
//            현재 위치에서 지정된 만큼 이동 + 애니메이션
            sv1.smoothScrollBy(0, 500)
            hsv1.smoothScrollBy(500, 0)
        }

        sv1.setOnScrollChangeListener(listener)
        hsv1.setOnScrollChangeListener(  View.OnScrollChangeListener { v: View?, scrollX: Int, scrollY: Int, oldScrollX: Int, oldScrollY: Int ->
            when(v?.id) {
                R.id.hsv1 -> {
                    textView2.text ="X : $oldScrollX -> $scrollX"
                }
            }
        })

    }
    private val listener = object : View.OnScrollChangeListener{
        override fun onScrollChange(v: View?, scrollX: Int, scrollY: Int, oldScrollX: Int, oldScrollY: Int) {
            when(v?.id) {
                R.id.sv1 -> {
                    textView1.text = "Y : ${oldScrollY} => ${scrollY}"
                }
            }
        }
    }
}