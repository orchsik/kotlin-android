package com.orchsik.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.orchsik.fragment.databinding.FragmentBinding

/**
 * 여러 화면을 가지고 있는 애플리케이션은 여러 Activity를 가지고 있게 된다.
 * Activity는 독립된 실행단위로 메모르리를 많이 소모하는데 독립된 실행단위가 아닌 화면만 필요한 경우
 * Fragment를 활용하는 것이 효율적이다.
 * Fragment는 Activity내의 작은 화면 조각으로 Activity의 화면을 여러 영역으로 나누어 관리할 목적으로 사용.
 *
 * back button은 현재 Activity를 종료한다. Fragment는 Activity가 아니므로 종료되지 않는다.
 * AddToBackStack 메서드를 통해 Back Stack에 포함시키면 제거할 수 있다.
 */
class Fragment : AppCompatActivity() {
    private lateinit var binding: FragmentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val frag1 = FirstFragment()
        binding.button.setOnClickListener {
            // Fragment 작업 시작
            val tran = supportFragmentManager.beginTransaction()
            // Fragment 세팅
            // tran.add(R.id.container1, frag1)
            tran.replace(R.id.container1, frag1)
            tran.addToBackStack(null)
            tran.commit()
        }

        val frag2 = SecondFragment()
        binding.button2.setOnClickListener {
            val tran = supportFragmentManager.beginTransaction()
            // tran.add(R.id.container1, frag2)
            tran.replace(R.id.container1, frag2)
            tran.addToBackStack(null)
            tran.commit()
        }

    }
}