package com.orchsik.helloadapterview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.custom_adapter.*
import kotlinx.android.synthetic.main.custom_adapter_row.view.*

/**
 * BaseAdapter를 상속받아 구현하면 AdapterView를 커스터마이징 할 수 있다.
 * 문자열 하나만 세팅 -> ArrayAdapter
 * 이미지 등등 여러가지 세팅 -> SimpleAdapter
 * 특별한 이벤트 부여 -> 커스터마이징
 *
 * AdapterView의 항목을 자유롭게 디자인해서 사용할 때는 SimpleAdapter 만으로도 충분하다.
 * 하지만 특별한 기능을 부여하고 싶을 때는 Adapter 클래스를 커스터마이징 해야한다.
 * [Example] - 기본 리스트뷰는 항목 터치리스너가 있지만,
 * 나는 항복내의 버튼1, 버튼2에 각각 리스너를 주고 싶은 상황.
 */
class CustomAdapter : AppCompatActivity() {
  private val data1 = arrayOf("data1", "data2", "data3", "data4", "data5")

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.custom_adapter)

    list1.adapter=adapter1
  }

  private val adapter1 = object : BaseAdapter() {
    // 항목의 개수 반환
    override fun getCount(): Int {
      return data1.size
    }

    override fun getItem(position: Int): Any? { return null }

    override fun getItemId(position: Int): Long { return  0 }

    // 리스트의 항목 중 첫화면이나 스크롤로 인해 아이템(뷰)이 새로 화면에 나타날 때 마다 호출.
    // 항목 하나마다 구성하기 위해 호출되는 메서드
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
      var rowView = convertView
      if(rowView == null) {
        rowView = layoutInflater.inflate(R.layout.custom_adapter_row, null)
      }

//      // rowTextView는 리스트뷰의 아이템이므로, View의 id를 알지 못 해서 아래와 같이 사용 불가능
//      // activity가 관리하는 것만 사용 가능.
//      // rowTextView.text = data1[position]
//      // 각 로우의 뷰에 배치되어 있는 주소값을 가져와야 한다.
//      val text1 = rowView?.findViewById<TextView>(R.id.rowTextView)
//      val btn1 = rowView?.findViewById<Button>(R.id.rowButton1)
//      val btn2 = rowView?.findViewById<Button>(R.id.rowButton2)
//
//      text1?.text = data1[position]
//
//      btn1?.tag = position + 1
//      btn2?.tag = position + 1
//
//      btn1?.setOnClickListener {
//        textView.text = "Button1 Clicked.: data${it.tag}"
//      }
//      btn2?.setOnClickListener {
//        textView.text = "Button2 Clicked.: data${it.tag}"
//      }

      // Kotlin 사용시 아래와 같이 run 메서드 사용하면 가능하다.
      rowView?.run {
        rowTextView.text = data1[position]
        rowButton1.tag = position + 1
        rowButton2.tag = position + 1
        rowButton1.setOnClickListener {
          textView.text = "Button1 Clicked: data${it.tag}"
        }
        rowButton2.setOnClickListener {
          textView.text = "Button2 Clicked: data${it.tag}"
        }
      }

      return rowView!!
    }
  }
}