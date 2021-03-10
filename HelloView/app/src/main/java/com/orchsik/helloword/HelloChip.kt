package com.orchsik.helloword

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.hello_chip.*

class HelloChip : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hello_chip)
//        textView1
//        chip1
        chip1.setOnClickListener {
            textView1.text = "chip1 clicked"

            if(chip2.isChecked) {
                textView1.append("\nchip2 is clicked")
            } else {
                textView1.append("\nchip2 is not clicked")
            }

            if(chip4.isChecked) {
                textView1.append("\ncheck3 is checked")
            } else {
                textView1.append("\ncheck3 is not checked")
            }

            if(chip5.isChecked) {
                textView1.append("\ncheck4 is checked")
            } else {
                textView1.append("\ncheck4 is checked")
            }

            when(chipgroup1.checkedChipId) {
                R.id.chip6 -> textView1.append("\ncheck6 is checked")
                R.id.chip7 -> textView1.append("\ncheck7 is checked")
                R.id.chip8 -> textView1.append("\ncheck8 is checked")
            }

        }

        chip4.setOnClickListener {
            textView1.text = "chip3 checked"
        }

        chip4.setOnCloseIconClickListener {
            textView1.text = "you click close button"
        }

        chip5.setOnCheckedChangeListener { compoundButton, isChecked ->
            if (isChecked) {
                textView1.text = "4 is checked"
            } else {
                textView1.text = "4 is checked"
            }
        }
    }
}