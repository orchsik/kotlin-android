package com.orchsik.helloword

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RatingBar
import kotlinx.android.synthetic.main.hello_ratingbar.*

class HelloRatingBar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hello_ratingbar)

//        ratingBar1
//        ratingBar2
//        ratingBar3
//        ratingBar4
//        textView1
//        textView2
//        textView3
//        button1
//        button2
        button1.setOnClickListener{
            textView1.text = "rating 1 : ${ratingBar1.rating}\n"
            textView1.append("rating 2 : ${ratingBar2.rating}\n")
            textView1.append("rating 3: ${ratingBar3.rating}\n")
            textView1.append("rating4: ${ratingBar4.rating}\n")
        }

        button2.setOnClickListener {
            ratingBar1.rating = 1.0f
            ratingBar2.rating = 2.0f
            ratingBar3.rating = 3.0f
            ratingBar4.rating = 4.0f
        }

        ratingBar2.onRatingBarChangeListener = listener
        ratingBar3.onRatingBarChangeListener = listener
        ratingBar4.onRatingBarChangeListener = RatingBar.OnRatingBarChangeListener { _, rating, fromUser ->
            textView1.text = "Rating 4 : ${rating}\n"
            if(fromUser) {
                textView1.append("from user")
            } else {
                textView1.append("from code")
            }
        }
//        ratingBar4.setOnRatingBarChangeListener(object : RatingBar.OnRatingBarChangeListener{
//            override fun onRatingChanged(ratingBar: RatingBar?, rating: Float, fromUser: Boolean) {
//                when(ratingBar?.id) {
//                    R.id.ratingBar4 -> {
//                        textView1.text = "Rating 4 : ${rating}\n"
//                        if(fromUser) {
//                            textView1.append("from user")
//                        } else {
//                            textView1.append("from code")
//                        }
//                    }
//                }
//            }
//        })
    }


    private var listener = object : RatingBar.OnRatingBarChangeListener {
        override fun onRatingChanged(ratingBar: RatingBar?, rating: Float, fromUser: Boolean) {
            when(ratingBar?.id) {
                R.id.ratingBar2 -> {
                    textView1.text = "Rating 2 : ${rating} \n"
                    if(fromUser) {
                        textView1.append("from user")
                    } else {
                        textView1.append(("from code"))
                    }
                }
                R.id.ratingBar3 -> {
                    textView1.text = "Rating 3 : ${rating} \n"
                    if(fromUser) {
                        textView1.append("From user")
                    } else {
                        textView1.append("From code")
                    }
                }
            }
        }
    }
}