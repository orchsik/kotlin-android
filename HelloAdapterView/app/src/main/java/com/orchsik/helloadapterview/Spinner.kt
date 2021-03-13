package com.orchsik.helloadapterview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.spinner.*

/**
 *  사용자에게 항목을 주고 선택하게 할 수 있는 AdapterView
 *  작은 스마트폰 화면을 효율적으로 사용
 */
class Spinner : AppCompatActivity() {

  val data1 = arrayOf("item1", "item2", "item3", "item4", "item5")

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.spinner)

    // 어댑터 생성. 접혔을 때의 모습을 구성할 layout을 설정
    val adapter1 = ArrayAdapter(this, android.R.layout.simple_spinner_item, data1)
    // 펼쳐졌을 때의 모습을 구성하기 위한 layout 지정
    adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
    spinner.adapter = adapter1

    button.setOnClickListener {
      textView.text = "selected: ${data1[spinner.selectedItemPosition]}"
    }

    spinner.onItemSelectedListener = listener1
  }

  private val listener1 = object: AdapterView.OnItemSelectedListener {
    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
      when(parent?.id) {
        R.id.spinner -> {
          textView.text = "${data1[position]} is selected."
        }
      }

    }
    override fun onNothingSelected(parent: AdapterView<*>?) {
    }
  }

}