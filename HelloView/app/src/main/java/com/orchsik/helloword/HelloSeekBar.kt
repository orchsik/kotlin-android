package com.orchsik.helloword

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import kotlinx.android.synthetic.main.hello_seekbar.*

class HelloSeekBar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hello_seekbar)

//        seekBar1
//        seekBar2
//        textView1
//        textView2
//        button1
//        button2

        button1.setOnClickListener {
            textView1.text = "seekbar 1 :  ${seekBar1.progress}"
            textView2.text = "seekbar 2 :  ${seekBar2.progress}"
        }

        button2.setOnClickListener {
            seekBar1.progress = 0
            seekBar2.progress = 0
        }

        button3.setOnClickListener {
            seekBar1.incrementProgressBy(1)
            seekBar2.incrementProgressBy(1)
        }

        button4.setOnClickListener {
            seekBar1.incrementProgressBy(-1)
            seekBar2.incrementProgressBy(-1)
        }

        seekBar1.setOnSeekBarChangeListener(listener)
        seekBar2.setOnSeekBarChangeListener(listener)
    }

    private val listener = object : SeekBar.OnSeekBarChangeListener {
        // progressbar  값 변경시
        override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
            when(seekBar?.id) {
                R.id.seekBar1 -> textView1.text = "seekBar 1 : ${seekBar1.progress}"
                R.id.seekBar2 -> textView1.text = "seekBar 2 : ${seekBar2.progress}"
            }

            if(fromUser) {
                textView2.append("from user")
            } else {
                textView2.append("from code")
            }
        }
        // 사용자 터치 시작
        override fun onStartTrackingTouch(seekBar: SeekBar?) {
            when(seekBar?.id) {
                R.id.seekBar1 -> textView2.text ="seekBar1 touched"
                R.id.seekBar2 -> textView2.text ="seekBar2 touched"
            }
        }
        // 사용자 터치 종료
        override fun onStopTrackingTouch(seekBar: SeekBar?) {
            when(seekBar?.id) {
                R.id.seekBar1 -> textView2.text = "seekBar1 touch end"
                R.id.seekBar2 -> textView2.text = "seekBar2 touch end"
            }
        }
    }
}