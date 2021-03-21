package com.orchsik.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.orchsik.fragment.databinding.ActivityMainBinding

/**
 * 여러 화면을 가지고 있는 애플리케이션은 여러 Activity를 가지고 있게 된다.
 * Activity는 독립된 실행단위로 메모르리를 많이 소모하는데 독립된 실행단위가 아닌 화면만 필요한 경우
 * Fragment를 활용하는 것이 효율적이다.
 * Fragment는 Activity내의 작은 화면 조각으로 Activity의 화면을 여러 영역으로 나누어 관리할 수 있다.
 */
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}