package com.orchsik.helloadapterview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import kotlinx.android.synthetic.main.multi_choice_listview.*

/**
 * 다수의 항목을 제공하고 항목 중 다수를 선택할 수 있는 ListView
 * ListView의 Mode를 변경하여 설정
 */
class MultiChoiceListView : AppCompatActivity() {

  private val data1 = arrayOf("item1", "item2", "item3", "item4", "item5", "item6", "item7", "item8", "item9", "item10")

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.multi_choice_listview)

    val adapter1 = ArrayAdapter(this, android.R.layout.simple_list_item_multiple_choice, data1)
    list1.adapter  = adapter1
    list1.choiceMode = ListView.CHOICE_MODE_MULTIPLE
    list1.setItemChecked(0, true)
    list1.setItemChecked(1, true)

    button.setOnClickListener {
      textView.text = ""
      // 체크 상태에 관련된 객체
      // 현재체크 -> [idx]: true
      // 과거체크 -> [idx]: false
      val boolArray = list1.checkedItemPositions
      for(idx in 0 until boolArray.size()) {
        val key = boolArray.keyAt(idx)
        // 해당 항목 체크 여부 확인
        if(boolArray[key]) {
          textView.append("${data1[key]},")
        }
      }
    }
  }
}