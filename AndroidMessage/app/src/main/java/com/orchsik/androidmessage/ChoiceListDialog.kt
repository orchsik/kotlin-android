package com.orchsik.androidmessage

import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.orchsik.androidmessage.databinding.ChoiceListDialogBinding

class ChoiceListDialog : AppCompatActivity() {

    private val data1 = arrayOf("item1", "item2", "item3", "item4", "item5", "item6", "item7", "item8", "item9", "item10"
        , "item11", "item12", "item13", "item14", "item15", "item16", "item17", "item18", "item19", "item20")

    private lateinit var binding: ChoiceListDialogBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ChoiceListDialogBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        /**
         * Single Choice ListDialog
         */
        binding.button.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Single Choice List Dialog")

            builder.setSingleChoiceItems(data1, 3, DialogInterface.OnClickListener {dialog, which ->
                val t1 = Toast.makeText(this, data1[which], Toast.LENGTH_SHORT)
                t1.show()
            })

            builder.setNegativeButton("Cancel", null)
            builder.setPositiveButton("Ok", DialogInterface.OnClickListener {dialog, which ->
                val alertDialog = dialog as AlertDialog
                val idx = alertDialog.listView.checkedItemPosition
                binding.textView.text = "선택된 항목: ${data1[idx]}"
            } )

            builder.show()
        }

        /**
         * Multi Choice ListDialog
         */
        binding.button2.setOnClickListener {
            val builder = AlertDialog.Builder(this)

            val boolArray = booleanArrayOf(true, false, true, false, true, true, false, false, false, false
                , true, false, true, false, true, true, false, false, false, false)

            builder.setMultiChoiceItems(
                data1,
                boolArray,
                DialogInterface.OnMultiChoiceClickListener { dialog, which, isChecked ->
                    if (isChecked) {
                        val t1 = Toast.makeText(this, "${data1[which]} chekced", Toast.LENGTH_SHORT)
                        t1.show()
                    } else {
                        val t1 = Toast.makeText(this, "${data1[which]} not chekced", Toast.LENGTH_SHORT)
                        t1.show()
                    }
                })

            builder.setNegativeButton("Cancel", null)
            builder.setPositiveButton("Ok", DialogInterface.OnClickListener { dialog, which ->
                binding.textView.text = ""

                val alertDialog = dialog as AlertDialog
                val positions = alertDialog.listView.checkedItemPositions
                for (i in 0 until positions.size()) {
                    // 체크 상태가 변경된 항목의 인덱스 번호를 추출.
                    var index = positions.keyAt(i)
                    if (positions.get(index)) {
                        binding.textView.append("${data1[index]} ")
                    }
                }
            })

            builder.show()
        }
    }
}