package com.orchsik.helloword

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioGroup
import kotlinx.android.synthetic.main.hello_radiobutton.*

class HelloRadioButton : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hello_radiobutton)
//        textView8
//        textView9
//        radioGroup1
//        radioButton1
//        radioButton2
//        radioButton3
//        radioGroup1
//        radioButton4
//        radioButton5
//        radioButton6
//        button44
//        button45

        button44.setOnClickListener {
            radioButton3.isChecked = true;
            radioButton6.isChecked = true
        }

        button45.setOnClickListener {
            when(radioGroup1.checkedRadioButtonId) {
                R.id.radioButton1 -> textView8.text = "checked 1"
                R.id.radioButton2 -> textView8.text = "checked 2"
                R.id.radioButton3 -> textView8.text = "checked 3"
            }
            when(radioGroup2.checkedRadioButtonId) {
                R.id.radioButton4 -> textView9.text = "checked 4"
                R.id.radioButton5 -> textView9.text = "checked 5"
                R.id.radioButton6 -> textView9.text = "chceckd 6"
            }
        }

        radioGroup1.setOnCheckedChangeListener(listener)
//        radioGroup2.setOnCheckedChangeListener(listener)
        radioGroup2.setOnCheckedChangeListener(object : RadioGroup.OnCheckedChangeListener{
            override fun onCheckedChanged(group: RadioGroup?, btnId: Int) {
                when(group?.id) {
                    R.id.radioGroup2 -> {
                        when(btnId) {
                            R.id.radioButton4 -> textView9.text = "checked 4"
                            R.id.radioButton5 -> textView9.text = "checked 5"
                            R.id.radioButton6 -> textView9.text = "checked 6"
                        }

                    }
                }

            }
        })
    }

    private var listener = object : RadioGroup.OnCheckedChangeListener {
        override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
            when(group?.id) {
                R.id.radioGroup1 -> {
                    when(checkedId){
                        R.id.radioButton1 -> textView8.text = "checked 1"
                        R.id.radioButton2 -> textView8.text = "checked 2"
                        R.id.radioButton3 -> textView8.text = "checked 3"
                    }
                }
//                R.id.radioGroup2 -> {
//                    when(checkedId){
//                        R.id.radioButton4 -> textView9.text = "checked 4"
//                        R.id.radioButton5 -> textView9.text = "checked 5"
//                        R.id.radioButton6 -> textView9.text = "checked 6"
//                    }
//                }
            }
        }
    }
}
