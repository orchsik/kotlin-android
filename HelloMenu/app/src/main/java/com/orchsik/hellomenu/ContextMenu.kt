package com.orchsik.hellomenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.orchsik.hellomenu.databinding.ContextmenuLayoutBinding

/**
 * ContextMenu: 화면에 배치된 View에 설정할 수 있는 메뉴
 * 메뉴가 설정된 View를 길게 누르면 메뉴가 나타난다.
 */
class ContextMenu : AppCompatActivity() {

  val data1 = arrayOf("item1", "item2", "item3", "item4", "ittem5")

  private lateinit var binding : ContextmenuLayoutBinding
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ContextmenuLayoutBinding.inflate(layoutInflater)
    setContentView(binding.root)

    val adapter1 =  ArrayAdapter(this, android.R.layout.simple_list_item_1, data1)
    binding.list1.adapter = adapter1

    binding.list1.setOnItemClickListener { parent, view, position, id ->
      binding.textView.text = "리스트뷰의 항목 클릭: ${data1[position]}"
    }

    /**
     * registerForContextMenu: ContextMenu를 등록하는 메서드
     * 매개 변수로 넣어준 View 객체에 메뉴가 설정된다.
     */
    registerForContextMenu(binding.textView)
    registerForContextMenu(binding.list1)


  }

  /**
   * View를 길게 누르면 호출되는 메서드. 여기에서 메뉴 구성.
   */
  override fun onCreateContextMenu(
    menu: ContextMenu?,
    v: View?,
    menuInfo: ContextMenu.ContextMenuInfo?
  ) {
    super.onCreateContextMenu(menu, v, menuInfo)

    // View id로 분기
    when(v?.id) {
      R.id.textView -> {
        menu?.setHeaderTitle("TextView Menu")
        menuInflater.inflate(R.menu.contextmenu1, menu)
      }
      R.id.list1 -> {
        // 사용자가 누른 항목 인덱스 번호 파악.
        val info  = menuInfo as AdapterView.AdapterContextMenuInfo

        menu?.setHeaderTitle("ListView Menu: ${info.position}")
        menuInflater.inflate(R.menu.contextmenu2, menu)
      }

    }


  }

  /**
   * 메뉴아이템이 선택되었을 때 호출.
   */
  override fun onContextItemSelected(item: MenuItem): Boolean {
    // 리스트 항목의 인덱스 번호를 받을 변수
    var position = 0
    when(item.itemId) {
      R.id.listitem1, R.id.listitem2 -> {
        // MenuInfo 객체 추출
        val info = item.menuInfo as AdapterView.AdapterContextMenuInfo
        position = info.position
      }
    }

    // 메뉴의 id로 분기
    when(item.itemId) {
      R.id.item1 -> {
        binding.textView.text = "MenuItem1 clicked."
      }
      R.id.item2 -> {
        binding.textView.text = "MenuItem2 clicked."
      }
      R.id.listitem1 -> {
        binding.textView.text = "ListMenuItem1 clicked: $position."
      }
      R.id.listitem2 -> {
        binding.textView.text = "ListMenuItem2 clicked: $position."
      }
    }

    return super.onContextItemSelected(item)


  }


}