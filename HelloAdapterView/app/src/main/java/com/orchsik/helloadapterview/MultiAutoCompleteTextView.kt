package com.orchsik.helloadapterview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.MultiAutoCompleteTextView
import kotlinx.android.synthetic.main.multi_autocomplete_textview.*

/**
 * AutoCompleteTextView와 거의 동일하며 구분자를 활용해 여러 문자열을 동시에 입력받을 수 있는 AdapterView
 * setTokenizer: 구분자 설정
 */
class MultiAutoCompleteTextView : AppCompatActivity() {
  private val data1 = arrayOf("abcd", "aasdf", "aqwer", "azxcvz", "basdf", "bqwer", "casdf", "asdfas", "dadsf")

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.multi_autocomplete_textview)

    val adapter1 = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, data1)
    // 구분자(,) 설정
    multiAutoCompleteTextView.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())
    multiAutoCompleteTextView.setAdapter(adapter1)

    button.setOnClickListener {
      val strArray = multiAutoCompleteTextView.text.split(",")
      textView.text = ""
      for(str1 in strArray) {
        if(str1.trim() != "") {
          textView.append("${str1.trim()}\n")
        }
      }
    }

    multiAutoCompleteTextView.setOnItemClickListener { parent, view, position, id ->
      rowTextView.text = "${data1[position]} is Clicked."
    }
  }
}