package com.orchsik.helloadapterview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.viewpager.*

/**
 * PagerAdapter는 좌우로 스왚화면서 View를 전환하는 AdapterView.
 * 화면이 바뀌는 것이 아니라 화면의 크기만한 View를 생성하여 View를 전환하는 개념
 * 현재 ViewPager를 업그레이드한 ViewPager2 제공.
 * ViewPager는 View 전환할 때, ViewPager2는 Fragment라는 것을 전환할 때 사용
 */
class ViewPager : AppCompatActivity() {
  // ViewPager를 통해 보여줄 View 리스트
  private val views = ArrayList<View>()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.viewpager)

    val view1 = layoutInflater.inflate(R.layout.view1, null)
    val view2 = layoutInflater.inflate(R.layout.view2, null)
    val view3 = layoutInflater.inflate(R.layout.view3, null)
    val view4 = layoutInflater.inflate(R.layout.view1, null)
    val view5 = layoutInflater.inflate(R.layout.view2, null)
    val view6 = layoutInflater.inflate(R.layout.view3, null)
    views.add(view1)
    views.add(view2)
    views.add(view3)
    views.add(view4)
    views.add(view5)
    views.add(view6)

    val adapter = object : PagerAdapter() {
      // ViewPager가 보여줄 View의 개수
      override fun getCount(): Int { return views.size }
      // ViewPager가 보여줄 View를 반환
      override fun instantiateItem(container: ViewGroup, position: Int): Any {
        pager1.addView(views[position])
        return views[position]
      }
      // instantiateItem이 반환한 객체를 화면으로 사용할 것인가를 검사
      override fun isViewFromObject(view: View, obj: Any): Boolean {
        return view == obj
      }
      // 스왚되서 안보이는 View 객체를 삭제하는 메서드
      override fun destroyItem(container: ViewGroup, position: Int, obj: Any) {
        pager1.removeView(obj as View)
      }
    }

    pager1.adapter = adapter

    val listener1 = object : ViewPager.OnPageChangeListener{
      // 페이지의 스크롤 상태가 변경되었을 때 호출되는 메서드
      override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
      }
      // 페이지의 스크롤이 끝났을 때 호출되는 메서드
      override fun onPageSelected(position: Int) {
        textView.text = "${position+1}번째 View가 나타났습니다."
      }
      // 페이지를 선택했을 때 호출되는 메서드
      override fun onPageScrollStateChanged(state: Int) {
      }
    }

    pager1.addOnPageChangeListener(listener1)
  }
}