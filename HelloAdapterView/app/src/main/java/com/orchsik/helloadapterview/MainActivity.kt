package com.orchsik.helloadapterview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SimpleAdapter
import kotlinx.android.synthetic.main.customlistview2.*

class MainActivity : AppCompatActivity() {

  private val imgRes = intArrayOf(R.drawable.imgflag1, R.drawable.imgflag2, R.drawable.imgflag3, R.drawable.imgflag4
    , R.drawable.imgflag5, R.drawable.imgflag6, R.drawable.imgflag7, R.drawable.imgflag8
  )
  private val data1 = arrayOf("토고", "프랑스", "스위스", "스페인", "일본", "독일", "브라질", "대한민국")
  private val data2 = arrayOf("togo", "france", "swiss", "spain", "japan", "german", "brazil", "korea")

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.customlistview2)

    // SimpleAdapter 에 세팅할 데이터
    val dataList  = ArrayList<HashMap<String, Any>>();
    // imgRes.indices : imgRes 리스트의 인덱스가 들어있는 리스트
    for(i in imgRes.indices) {
      // 항목 하나를 구성하기 위해 필요한 데이터를 담고 있는 HashMap
      val map = HashMap<String, Any>()
      map["img"] = imgRes[i]
      map["data1"] = data1[i]
      map["data2"] = data2[i]
      dataList.add(map)
    }

    // HashMap 에 데이터를 저장했을 때 사용했던 이름
    val keys = arrayOf("img", "data1", "data2")
    // 데이터를 세팅할 View의 id 배열
    val ids = intArrayOf(R.id.rowImageView, R.id.rowTextView1, R.id.rowTextView2)

    /**
     * @param data = dataList @@ A List of Maps. Each entry in the List corresponds to one row in the list. The
     *        Maps contain the data for each row, and should include all the entries specified in
     *        "from"
     * @param resource = R.layout.row2 @@ Resource identifier of a view layout that defines the views for this list
     *        item. The layout file should include at least those named views defined in "to"
     * @param from = keys @@ A list of column names that will be added to the Map associated with each
     *        item.
     * @param to = ids @@ The views that should display column in the "from" parameter. These should all be
     *        TextViews. The first N views in this list are given the values of the first N columns
     *        in the from parameter.
     */
    val adapter1 = SimpleAdapter(this, dataList, R.layout.row2, keys, ids)
    list1.adapter = adapter1

    list1.setOnItemClickListener { parent, view, position, id ->
      textView.text = "${data1[position]} is Clicked."
    }
  }
}