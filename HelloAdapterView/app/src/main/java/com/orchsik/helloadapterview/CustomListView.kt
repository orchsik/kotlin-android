package com.orchsik.helloadapterview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.customlistview.*
import kotlinx.android.synthetic.main.row.*

class CustomListView : AppCompatActivity() {

  val data1 = arrayOf("string0", "string1", "string2", "string3", "string4" )

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.customlistview)

    /**
     * @param resource 레이아웃파일 / R.layout.row
     * @param textViewResourceId  layout 파일 내에서 문자열을 설정할 View의 아이디 / R.id.rowTextView
     */
    val adapter1 = ArrayAdapter(this, R.layout.row, R.id.rowTextView, data1)
    list1.adapter = adapter1

    list1.setOnItemClickListener { parent, view, position, id ->
      textView.text = "${data1[position]} is Clicked."
    }

  }

}