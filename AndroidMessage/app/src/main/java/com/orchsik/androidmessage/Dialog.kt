package com.orchsik.androidmessage

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.orchsik.androidmessage.databinding.CustomDialogBinding
import com.orchsik.androidmessage.databinding.DialogBinding
import java.util.*

class Dialog : AppCompatActivity() {
    private lateinit var binding: DialogBinding
    private lateinit var customDialogBinding: CustomDialogBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DialogBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.button.setOnClickListener {
            var builder = AlertDialog.Builder(this)

            builder.setTitle("Basic Dialog")
            builder.setMessage("This is Basic Dialog")
            builder.setIcon(R.mipmap.ic_launcher)

            builder.setPositiveButton("Positive") {dialogInterface, i ->
                binding.textView.text = "Positive Button is clicked."
            }
            builder.setNeutralButton("Neutral") {dialogInterface, i ->
                binding.textView.text = "Neutral Button is clicked."
            }
            builder.setNegativeButton("Native") {dialogInterface, i ->
                binding.textView.text = "Native Button is clicked."
            }

            builder.show()
        }

        /**
         * Custom Dialog
         */
        binding.button2.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Custom Dialog")
            builder.setIcon(R.mipmap.ic_launcher)

            customDialogBinding = CustomDialogBinding.inflate(layoutInflater)
            val customView = customDialogBinding.root
            builder.setView(customView)

            builder.setPositiveButton("Confirm") {dialogInterface, i ->
                customDialogBinding.run{
                    binding.textView.text = "${customEdit1.text}\n"
                    binding.textView.append("${customEdit2.text}")
                }
            }
            builder.setNegativeButton("Cancel", null)

            builder.show()
        }

        /**
         * DatePicker Dialog
         */
        binding.button3.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val listener =  DatePickerDialog.OnDateSetListener {view, year, month, dayOfMonth ->
                binding.textView.text = "${year}년 ${month+1}월 ${dayOfMonth}일"
            }

            val datePickerDialog = DatePickerDialog(this, listener, year, month, day)

            datePickerDialog.show()
        }

        /**
         * TimePicker Dialog
         */
        binding.button4.setOnClickListener {
            val calendar  = Calendar.getInstance()
            val hour = calendar.get(Calendar.HOUR)
            val minutes = calendar.get(Calendar.MINUTE)

            val listener = TimePickerDialog.OnTimeSetListener{view, hourOfDay, minute ->
                binding.textView.text = "${hourOfDay}시 ${minute}분"
            }

            val timePickerDialog = TimePickerDialog(this, listener, hour, minutes, true)

            timePickerDialog.show()
        }
    }
}