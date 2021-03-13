package com.orchsik.helloadapterview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.recycler_row.view.*
import kotlinx.android.synthetic.main.recyclerview.*

/**
 * Android 5.0 때 추가
 * ListView, GridView의 구현이 비슷한 부분이 많아 이를 통합한 View.
 * Adapter를 직접 구현해줘야 하며, 이를 통해 항목을 자유롭게 구성할 수 있음.
 * 반드시 항목을 어떤 형태로 보여줄 것인가를 설정해야 함.
 */
class RecylerView : AppCompatActivity() {
  private var imgRes = intArrayOf(
    R.drawable.imgflag1,
    R.drawable.imgflag2,
    R.drawable.imgflag3,
    R.drawable.imgflag4,
    R.drawable.imgflag5,
    R.drawable.imgflag6,
    R.drawable.imgflag7,
    R.drawable.imgflag8,
  )
  private var data1 = arrayOf("토고", "프랑스 문자열이 엄청 길어~", "스위스", "스페인", "일본 문자열도 진짜 길어~", "독일", "브라질", "대한민국")

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.recyclerview)

    val adapter1 = RecyclerAdapter()
    recycler1.adapter = adapter1

    recycler1.layoutManager = LinearLayoutManager(this)
//    recycler1.layoutManager = GridLayoutManager(this, 2)
//    recycler1.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
//    recycler1.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.HORIZONTAL)
  }

  // RecyclerView의 Adapter
  // ViewHolderClass: 항목 하나를 구성하는 View의 주소값을 가지고 있는 클래스.
  inner class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolderClass>() {

    // 항목 구성을 위해 사용할 ViewHolder 객체가 필요할 때 호출되는 메서드
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
      // 항목으로 사용할 View 객체 생성
      val itemView = layoutInflater.inflate(R.layout.recycler_row, null)
      val holder = ViewHolderClass(itemView)
      itemView.setOnClickListener(holder)
      return holder
    }

    // ViewHolder를 통해 항목을 구성할 때, 항목 내의 View 객체에 데이터를 세팅한다.
    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
      holder.rowImageView.setImageResource(imgRes[position])
      holder.rowTextView.text = data1[position]
    }

    // Recycler 항목 개수 반환
    override fun getItemCount(): Int {
      return imgRes.size
    }

    // ViewHolder 클래스
    inner class ViewHolderClass(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener{
      // 항목 View 내부의 View 객체의 주소값을 담는다.
      val rowImageView : ImageView = itemView.rowImageView
      val rowTextView : TextView = itemView.rowTextView

      override fun onClick(v: View?) {
        textView.text = data1[adapterPosition]
      }
    }

  }

}