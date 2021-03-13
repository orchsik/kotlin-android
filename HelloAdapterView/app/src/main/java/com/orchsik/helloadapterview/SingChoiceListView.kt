package com.orchsik.helloadapterview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import kotlinx.android.synthetic.main.single_choice_listview.*

/**
 * 다수의 항목을 제공하고 항목 중 하나를 선택할 수 있는 ListView
 * ListView의 Mode를 변경하여 설정.
 */
class SingChoiceListView : AppCompatActivity() {
  private val data1 = arrayOf("item1", "item2", "item3", "item4", "item5", "item6", "item7", "item8")

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.single_choice_listview)

    val adapter1  = ArrayAdapter(this, android.R.layout.simple_list_item_single_choice, data1)
    list1.adapter = adapter1
    list1.choiceMode = ListView.CHOICE_MODE_SINGLE
    list1.setItemChecked(2, true)

    button.setOnClickListener {
      textView.text = "${data1[list1.checkedItemPosition]} clicked."
    }
  }
}