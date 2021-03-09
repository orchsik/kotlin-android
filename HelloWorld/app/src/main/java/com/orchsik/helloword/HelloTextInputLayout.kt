package com.orchsik.helloword

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.inputmethod.InputMethodManager
import kotlinx.android.synthetic.main.hello_textinputlayout.*
import kotlinx.android.synthetic.main.hello_textinputlayout.view.*

class HelloTextInputLayout : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hello_textinputlayout)

//        textinputLayout1
//        textinputEditText1
//        button25
//        textView


//        button25.setOnClickListener(object : View.OnClickListener{
//            override fun onClick(p0: View?) {
//                Something...
//            }
//        })
        button25.setOnClickListener {
            textinputLayout1.textView.text = textinputLayout1.editText?.text

            textinputLayout1.editText?.clearFocus()

            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(textinputLayout1.editText?.windowToken, 0)

        }

        textinputLayout1.editText?.addTextChangedListener(listener)
    }

    private val listener = object : TextWatcher {
        override fun afterTextChanged(p0: Editable?) {
            if(p0 != null) {
                if(p0.length > 10) {
                    textinputLayout1.error = "10글자 이하로 입력해라"
                } else {
                    textinputLayout1.error = null
                }
            }
        }
        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }
    }


}