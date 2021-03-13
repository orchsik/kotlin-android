package com.orchsik.hellomenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.orchsik.hellomenu.databinding.OptionMenuBinding

class OptionMenu : AppCompatActivity() {
  private lateinit var binding : OptionMenuBinding
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = OptionMenuBinding.inflate(layoutInflater)
    setContentView(binding.root)

  }

  /**
   * onCreateOptionMenu: 화면을 관리하는 객체인 Activity 객체가 만들어질 때 자동으로 호출되는 메서드
   * 여기에서 메뉴를 생성하게 된다. true를 반환하면 메뉴가 나타난다.
   * XML 또는 코드로 구성할 수 있다.
   */
  override fun onCreateOptionsMenu(menu: Menu?): Boolean {
    // XML로 메뉴 구성
    // menuInflater.inflate(R.menu.main_menu, menu)

    // Code로 메뉴 구성
    menu?.add(Menu.NONE, Menu.FIRST, Menu.NONE, "CODE MENU1")
    val sub  = menu?.addSubMenu(Menu.NONE, Menu.FIRST+1, Menu.NONE, "CODE MENU2")
    sub?.add(Menu.NONE, Menu.FIRST+10, Menu.NONE, "CODE MENU2-1")
    sub?.add(Menu.NONE, Menu.FIRST+20, Menu.NONE, "CODE MENU2-2")
    menu?.add(Menu.NONE, Menu.FIRST+2, Menu.NONE, "CODE MENU3")

    return true;
  }

  /**
   * 메뉴 아이템이 선택되었을 때
   */
  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    // XML로 구성한 메뉴 선택한 경우
    when(item.itemId) {
      R.id.item1 -> {
        binding.textView.text = "menu1 clicked."
      }
      R.id.item2 -> {
        binding.textView.text = "menu2 clicked."
      }
      R.id.item2_1 -> {
        binding.textView.text = "menu2_1 clicked."
      }
      R.id.item2_2 -> {
        binding.textView.text = "menu2_2 clicked."
      }
      R.id.item3 -> {
        binding.textView.text = "menu3 clicked."
      }
    }

    // 코드로 구성한 메뉴 선택한 경우
    when(item.itemId) {
      Menu.FIRST -> {
        binding.textView.text = "codeMenu1 clicked."
      }
      Menu.FIRST+1 -> {
        binding.textView.text = "codeMenu2 clicked."
      }
      Menu.FIRST+10 -> {
        binding.textView.text = "codeMenu2_1 clicked."
      }
      Menu.FIRST+20 -> {
        binding.textView.text = "codeMenu2_2 clicked."
      }
      Menu.FIRST+2 -> {
        binding.textView.text = "codeMenu3 clicked."
      }
    }

    return super.onOptionsItemSelected(item)
  }




}