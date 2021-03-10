package com.orchsik.helloword

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.hello_togglebutton.*

class HelloToggleButton : AppCompatActivity() {
    private fun checkStatus() {
        if(toggleButton.isChecked) {
            textView5.text = "status is ON"
        } else {
            textView5.text = "status is OFF"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hello_togglebutton)
//        textView5
//        textView6
//        toggleButton
//        toggleButton2
//        button35
//        button37
//        button38
//        button39
        button35.setOnClickListener {
            checkStatus()
        }
        button37.setOnClickListener {
            toggleButton.isChecked = true
            checkStatus()
        }
        button38.setOnClickListener {
            toggleButton.isChecked = false
            checkStatus()
        }
        button39.setOnClickListener {
            toggleButton.toggle()
            checkStatus()
        }

        toggleButton.setOnClickListener(listener)

        toggleButton2.setOnClickListener {
            if(toggleButton2.isChecked) {
                textView6.text = "ON !!!!!!!!!"
            } else {
                textView6.text = "OFF !!!!!!!!!!"
            }
        }
    }


    private val listener = View.OnClickListener {
        checkStatus()
    }
}