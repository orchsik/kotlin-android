package com.orchsik.helloadapterview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.girdview.*

/**
 * ListView와 거의 동일하며 항목을 그리드 형태로 보여줄 수 있는 View.
 * ListView와 상용법 동일
 */
class GridView : AppCompatActivity() {

  private val data1 = arrayOf("grid1", "gird2", "gird3", "gird4", "grid5", "grid6", "gird7", "gird8", "grid9", "grid10")

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.girdview)

    val adapter1 = ArrayAdapter(this, android.R.layout.simple_list_item_1, data1)
    grid1.adapter = adapter1

//    grid1.onItemClickListener = listener1
    grid1.setOnItemClickListener(object: AdapterView.OnItemClickListener{
      override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        when(parent?.id) {
          R.id.grid1 -> {
            textView.text = "${data1[position]} clicked."
          }
        }
      }
    })
  }

  private val listener1 = object: AdapterView.OnItemClickListener {
    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
      when(parent?.id) {
        R.id.grid1 -> {
          textView.text = "${data1[position]} clicked"
        }
      }
    }
  }
}