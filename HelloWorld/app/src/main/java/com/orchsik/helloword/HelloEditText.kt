package com.orchsik.helloword

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.hello_edittext.*

class HelloEditText: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hello_edittext)

        button1.setOnClickListener() {
            textView1.text = edittext1.text

            edittext1.clearFocus();

            // 키보드 내려가게 하기
            // getSystemService:  Andoird 기능 사용하고 싶을때
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(edittext1.windowToken, 0)
        }

        edittext1.addTextChangedListener(listenr1)

        edittext1.setOnEditorActionListener { _, _, _ ->
            textView1.text = "You press Enter Button"
            textView3.text = "You input: ${edittext1.text}"
            false   // 키보드 내려감
            // true   // 키보드 안 내려감
        }

    }

    var listenr1 = object : TextWatcher{
        // 문자열 변경 전
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            textView1.text = "beforeTextChanged : $p0"
        }
        // 문자열 변경 작업 완료 시
        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            textView3.text = "onTextChanged : $p0"
        }
        // 변경 문자열이 화면에 반영되었을 때
        override fun afterTextChanged(p0: Editable?) {
            textView4.text = "afterTextChanged : $p0"
        }
    }
}