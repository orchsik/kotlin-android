package com.orchsik.androidmessage

import android.content.DialogInterface
import android.os.Bundle
import android.widget.SimpleAdapter
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.orchsik.androidmessage.databinding.ListDialogBinding

class ListDialog : AppCompatActivity() {

    private val data1 = arrayOf("item1", "item2", "item3", "item4", "item5", "item6", "item7", "item8", "item9", "item10"
        , "item11", "item12", "item13", "item14", "item15", "item16", "item17", "item18", "item19", "item20")

    private val data2 = arrayOf("토고", "프랑스", "스위스", "스페인", "일본", "독일", "프랑스", "대한민국")
    private val data3 = intArrayOf(
        R.drawable.imgflag1,
        R.drawable.imgflag2,
        R.drawable.imgflag3,
        R.drawable.imgflag4,
        R.drawable.imgflag5,
        R.drawable.imgflag6,
        R.drawable.imgflag7,
        R.drawable.imgflag8,
    )

    private lateinit var binding: ListDialogBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ListDialogBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        binding.button.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("ListDialog")
            builder.setNegativeButton("Cancel", null)

            builder.setItems(data1, DialogInterface.OnClickListener { dialog, which ->
                binding.textView.text =  "Basic ListDialog: ${data1[which]}"
            })

            builder.show()
        }

        /**
         * Custom ListDialog
         */
        binding.button2.setOnClickListener {
            val itemList = ArrayList<HashMap<String, Any?>>()

            for(idx in data2.indices) {
                val hashMap = HashMap<String, Any?>()
                hashMap["data2"] = data2[idx]
                hashMap["data3"] = data3[idx]
                itemList.add(hashMap)
            }

            val keys = arrayOf("data2", "data3")
            val ids = intArrayOf(R.id.customTextView, R.id.customImage)
            val adapter = SimpleAdapter(this, itemList, R.layout.custom_list, keys, ids)

            val builder = AlertDialog.Builder(this)
            builder.setTitle("Custom ListDialog")
            builder.setAdapter(adapter, DialogInterface.OnClickListener { dialog, which ->
                binding.textView.text = "Custom ListDialog : ${data2[which]}"
            })
            builder.setNegativeButton("Cancel", null)

            builder.show()
        }
    }
}