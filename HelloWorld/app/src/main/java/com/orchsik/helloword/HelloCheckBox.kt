package com.orchsik.helloword

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CompoundButton
import kotlinx.android.synthetic.main.hello_checkbox.*

class HelloCheckBox : AppCompatActivity() {
    // textview7
    // checkbox1
    // checkbox2
    // checkbox3
    // button40
    // button41
    // button42
    // button43
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hello_checkbox)

        button40.setOnClickListener {
            textView7.text = ""
            if(checkBox1.isChecked) {
                textView7.append("chekced checkBox1\n")
            } else {
                textView7.append("not chekced checkBox1\n")
            }

            if(checkBox2.isChecked) {
                textView7.append("checked checkBox2\n")
            } else {
                textView7.append("not checked checkBox2\n")
            }

            if(checkBox3.isChecked) {
                textView7.append("checked checkBox3\n")
            } else {
                textView7.append("not chekced checkBox3\n")
            }
        }

        button41.setOnClickListener {
            checkBox1.isChecked = true
            checkBox2.isChecked = true
            checkBox3.isChecked = true
        }

        button42.setOnClickListener {
            checkBox1.isChecked = false
            checkBox2.isChecked = false
            checkBox3.isChecked = false
        }

        button43.setOnClickListener {
            checkBox1.toggle()
            checkBox2.toggle()
            checkBox3.toggle()
        }

        checkBox1.setOnCheckedChangeListener(listener)
        checkBox2.setOnCheckedChangeListener(listener)
        checkBox3.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked) {
                textView7.text = "checkbox3 checked"
            } else {
                textView7.text = "checkbox3 not checked"
            }
        }

//        checkBox3.setOnCheckedChangeListener(object : CompoundButton.OnCheckedChangeListener {
//            override fun onCheckedChanged(p0: CompoundButton?, p1: Boolean) {
//                if(p1) {
//                    textView7.text = "checkbox3 checked"
//                } else {
//                    textView7.text = "checkbox3 not checked"
//                }
//            }
//        })

//        checkBox3.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { _, p1 ->
//            if(p1) {
//                textView7.text = "checkbox3 checked"
//            } else {
//                textView7.text = "checkbox3 not checked"
//            }
//        })

//        checkBox3.setOnCheckedChangeListener{ _, p1 ->
//            if(p1) {
//                textView7.text = "checkbox3 checked"
//            } else {
//                textView7.text = "checkbox3 not checked"
//            }
//        }
    }

    private val listener = object : CompoundButton.OnCheckedChangeListener {
        // btnView: 상태가 변한 체크박스 객체
        // isChecked: 체크 상태값
        override fun onCheckedChanged(btnView: CompoundButton?, isChecked: Boolean) {
            when(btnView?.id) {
                R.id.checkBox1 -> {
                    if(isChecked) {
                        textView7.text = "checkbox1 checked"
                    } else {
                        textView7.text = "checkbox1 not checked"
                    }
                }
                R.id.checkBox2 -> {
                    if(isChecked) {
                        textView7.text = "checkbox2 checked"
                    } else {
                        textView7.text = "checkbox2 not checked"
                    }
                }
            }
        }
    }
}