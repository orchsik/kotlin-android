package com.orchsik.helloadapterview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class ListView : AppCompatActivity() {
  private val data1 = arrayOf(
    "string0", "string1", "string2", "string3", "string4", "string5", "string6", "string7", "string8", "string9",
    "string10", "string11", "string12", "string13", "string14", "string15", "string16", "string17", "string18", "string19",
    "string20", "string21", "string22", "string23", "string24", "string25", "string26", "string27", "string28", "string29",
    "string30", "string31", "string32", "string33", "string34", "string35", "string36", "string37", "string38", "string39",
    "string40", "string41", "string42", "string43", "string44", "string45", "string46", "string47", "string48", "string49",
  );

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    // p0:Context
    // p1:항목 하나를 구성하기 위해 사용할 layout 파일 (OS에서 제공하는 파일: android.R.layout.simple_list_item_1)
    // p3:항목 구성에 필요한 데이터
    val adapter1 = ArrayAdapter(this, android.R.layout.simple_list_item_1, data1)
    list1.adapter = adapter1

    list1.setOnItemClickListener(listener1)
  }

  private val listener1 = object : AdapterView.OnItemClickListener {
    // p0:전체 리스트 뷰 리스트
    // p1:사용자가 터치한 뷰
    // p2:터치한 뷰 인덱스
    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
      when(parent?.id) {
        R.id.list1 -> {
          textView.text = "${data1[position]} Clicked."
        }
      }
    }
  }
}