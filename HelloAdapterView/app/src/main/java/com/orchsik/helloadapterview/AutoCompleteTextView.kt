package com.orchsik.helloadapterview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.autocomplete_textview.*

/**
 * EditText에 자동완성 기능을 추가한 View
 * 사용자가 문자열을 입력하면 개발자가 설정둔 문자열 항목을 통해 자동완성 리스트를 제공
 */
class AutoCompleteTextView : AppCompatActivity() {
  private val data1 = arrayOf("abcd", "abca", "abcb", "bbaa", "bbab", "bcab", "bdab")

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.autocomplete_textview)

    val adapter1 = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, data1)

    autoCompleteTextView.setAdapter(adapter1)

    button.setOnClickListener {
      textView.text = autoCompleteTextView.text
    }

//    autoCompleteTextView.setOnItemClickListener(listener1)

    autoCompleteTextView.setOnItemClickListener { parent, view, position, id ->
      rowTextView.text = "${data1[position]} 항목을 클릭했습니다"
    }
  }

  private val listener1 = object :  AdapterView.OnItemClickListener {
    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
//      // 2021.03.13 기준 AutoCompleteTextView에서 parent 값이 제대로 안 들어옴
//      when(parent?.id) {
//        R.id.autoCompleteTextView -> {
//          textView2.text = "${data1[position]} 항목을 클릭했습니다."
//        }
//      }
      rowTextView.text = "${data1[position]} 항목을 클릭했습니다."
    }
  }
}