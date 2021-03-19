package com.orchsik.androidmessage

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar
import com.orchsik.androidmessage.databinding.CustomSnackbarBinding
import com.orchsik.androidmessage.databinding.SnackbarBinding

class SnackBar : AppCompatActivity() {
    private lateinit var binding: SnackbarBinding
    private lateinit var customSnackbarBinding : CustomSnackbarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SnackbarBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.button.setOnClickListener {
            binding.textView.text = ""

            val snack1 = Snackbar.make(it, "Basic snackBar", Snackbar.LENGTH_INDEFINITE)
            snack1.setTextColor(Color.RED)
            snack1.setBackgroundTint(Color.LTGRAY)
            snack1.animationMode = Snackbar.ANIMATION_MODE_FADE

            /**
             * SnackBar Action
             */
            snack1.setAction("SnackAction") {
                binding.textView.text = "SnackAction Clicked.\n"
            }

            /**
             * callback
             */
            val callback = object : BaseTransientBottomBar.BaseCallback<Snackbar>() {
                override fun onShown(transientBottomBar: Snackbar?) {
                    super.onShown(transientBottomBar)
                    binding.textView.append("SnackBar is shown.")
                }
                override fun onDismissed(transientBottomBar: Snackbar?, event: Int) {
                    super.onDismissed(transientBottomBar, event)
                    binding.textView.append("SnackBar is dismissed.")
                }
            }
            snack1.addCallback(callback)

            snack1.show()
        }

        binding.button2.setOnClickListener {
            val snack2 = Snackbar.make(it, "Custom SnackBar", Snackbar.LENGTH_SHORT)

            /**
             * Custom SnackBar
             * #1 SnackBar에 보여줄 View 생성
             * #2 SnackBar Layout을 추출해서 생성한 view 추가
             * #3 SnackBar의 기본 TextView를 추출해서 보이지 않게 처리
             */
            // #1
            customSnackbarBinding = CustomSnackbarBinding.inflate(layoutInflater)
            customSnackbarBinding.run {
                imageView.setImageResource(R.drawable.img_android)
                textView3.text = "New View"
                textView3.setTextColor(Color.WHITE)
            }
            val snackView  = customSnackbarBinding.root

            // #2
            val snackBarLayout = snack2.view as Snackbar.SnackbarLayout
            snackBarLayout.addView(snackView)
            // #3
            val snackBarText = snackBarLayout.findViewById<TextView>(com.google.android.material.R.id.snackbar_text)
            snackBarText.visibility = View.INVISIBLE

            snack2.show()
        }

    }
}