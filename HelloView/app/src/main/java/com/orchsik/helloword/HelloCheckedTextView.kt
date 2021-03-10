package com.orchsik.helloword

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckedTextView
import kotlinx.android.synthetic.main.hello_checkedtextview.*

class HelloCheckedTextView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hello_checkedtextview)
//        checkBox1
//        checkBox2
//        checkBox3
//        radio1
//        radio2
//        radio3
//        button1
//        button2
//        textView1

        button1.setOnClickListener {
            textView1.text = "checked box ="
            if (checkBox1.isChecked) textView1.append(" [1]")
            if (checkBox2.isChecked) textView1.append(" [2]")
            if (checkBox3.isChecked) textView1.append(" [3]")

            if (radio1.isChecked) textView1.append("\n checked radio is (1)")
            if (radio2.isChecked) textView1.append("\n checked radio is (2)")
            if (radio3.isChecked) textView1.append("\n checked radio is (3)")
        }


        button2.setOnClickListener {
            checkBox1.isChecked = false
            checkBox2.isChecked = true
            checkBox3.isChecked = false
            radio1.isChecked = true
            radio2.isChecked = false
            radio3.isChecked = false
        }

        checkBox1.setOnClickListener(checkBoxToggleListener)
        checkBox2.setOnClickListener(checkBoxToggleListener)
        checkBox3.setOnClickListener(checkBoxToggleListener)
        radio1.setOnClickListener(radioToggleListener)
        radio2.setOnClickListener(radioToggleListener)
        radio3.setOnClickListener(radioToggleListener)

    }

    private val checkBoxToggleListener = object : View.OnClickListener {
        override fun onClick(view: View?) {
            // 형변환 onClick의 인자로 View형태를 CheckTextVies 형태로 변환
            val obj = view as CheckedTextView
            obj.isChecked = !obj.isChecked
        }
    }

    private val radioToggleListener =  object : View.OnClickListener {
        override fun onClick(view: View?) {
            radio1.isChecked = false
            radio2.isChecked = false
            radio3.isChecked = false
            // 형변환
            val obj = view as CheckedTextView
            when(obj?.id) {
                R.id.radio1 -> radio1.isChecked = true
                R.id.radio2 -> radio2.isChecked = true
                R.id.radio3 -> radio3.isChecked = true
            }
        }
    }

}