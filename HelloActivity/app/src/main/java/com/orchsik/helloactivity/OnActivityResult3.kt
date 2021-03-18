package com.orchsik.helloactivity

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.orchsik.helloactivity.databinding.ActivityThirdBinding

class OnActivityResult3 : AppCompatActivity() {

    private lateinit var binding: ActivityThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.button3.setOnClickListener {
            setResult(Activity.RESULT_OK)
            finish()
        }

        binding.button5.setOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }

        binding.button6.setOnClickListener {
            setResult(Activity.RESULT_FIRST_USER)
            finish()
        }

        binding.button7.setOnClickListener {
            setResult(Activity.RESULT_FIRST_USER + 1)
            finish()
        }
    }
}