package com.orchsik.hellomenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.PopupMenu
import com.orchsik.hellomenu.databinding.PopupMenuLayoutBinding

/**
 * PopupMenu: 개발자가 원할 때 원하는 곳에 띄울 수 있는 메뉴.
 */
class PopupMenu : AppCompatActivity() {
  private lateinit var binding : PopupMenuLayoutBinding
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = PopupMenuLayoutBinding.inflate(layoutInflater)
    setContentView(binding.root)

    binding.button.setOnClickListener {
      // PopupMenu 객체 생성
      val pop = PopupMenu(this, binding.textView)

      // 메뉴 구성
      menuInflater.inflate(R.menu.popup_menu1, pop.menu)

      // 메뉴 아이템 선택 시
      pop.setOnMenuItemClickListener {
        when(it.itemId) {
          R.id.item1 -> {
            binding.textView.text = "menuItem1 clicked."
          }
          R.id.item2 -> {
            binding.textView.text = "menuItem2 clicked."
          }
          R.id.item3 -> {
            binding.textView.text = "menuItem3 clicked."
          }
        }
        true
      }

      pop.show()
    }


  }



}