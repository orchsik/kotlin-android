package com.orchsik.helloword

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.hello_progressbar.*

class HelloProgressBar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hello_progressbar)
//        pb1
//        pb2
//        pb3
//        pb4
//        textView1
//        button1
//        button2
//        button3
//        button4
        button1.setOnClickListener {
            textView1.text = "current status: ${pb4.progress}"
        }

        button2.setOnClickListener {
            pb4.progress = 140
        }

        button3.setOnClickListener {
//            pb4.progress += 10
            pb4.incrementProgressBy(10)
        }
        button4.setOnClickListener {
//            pb4.progress -= 10
            pb4.incrementProgressBy(-10)
        }
    }
}