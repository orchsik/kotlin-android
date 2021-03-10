package com.orchsik.helloword

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CompoundButton
import kotlinx.android.synthetic.main.hello_switch.*

class HelloSwitch : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hello_switch)
//        switch1
//        switch3
//        textView10
//        textView11
//        button46
//        button47
//        button48

        button46.setOnClickListener {
            if(switch1.isChecked) {
                textView10.text = "status ON"
            } else {
                textView10.text = "status OFF"
            }
        }

        button47.setOnClickListener {
            switch1.isChecked = true
        }

        button48.setOnClickListener {
            switch1.isChecked = false
        }

        switch1.setOnCheckedChangeListener(listener1)
        switch3.setOnCheckedChangeListener(object : CompoundButton.OnCheckedChangeListener{
            override fun onCheckedChanged(targetView: CompoundButton?, isChecked: Boolean) {
                when(targetView?.id) {
                    R.id.switch3 -> {
                        if(isChecked) textView11.text = "swtich2 is ON"
                        else textView11.text = "swtich2 is OFF"
                    }
                }
            }
        })
    }

    private val listener1 = object : CompoundButton.OnCheckedChangeListener {
        override fun onCheckedChanged(targetView: CompoundButton?, isChecked: Boolean) {
            when(targetView?.id) {
                R.id.switch1 -> {
                    if(isChecked) {
                        textView10.text = "switch1 is ON"
                    } else {
                        textView10.text = "switch1 is OFF"
                    }
                }
            }
        }
    }
}