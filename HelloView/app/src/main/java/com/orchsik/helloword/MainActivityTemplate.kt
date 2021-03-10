package com.orchsik.helloword

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivityTemplate : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hello_button)
    }
}