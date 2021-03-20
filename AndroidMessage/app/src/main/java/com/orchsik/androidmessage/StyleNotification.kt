package com.orchsik.androidmessage

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import com.orchsik.androidmessage.databinding.StyleNotificationBinding

class StyleNotification : AppCompatActivity() {
    private lateinit var binding: StyleNotificationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = StyleNotificationBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        /**
         * Big Image Notification
         */
        binding.button.setOnClickListener {
            val styleNotificationBuilder = getNotificationBuilder("style", "Style Notification")
            styleNotificationBuilder.setContentTitle("Big Picture")
            styleNotificationBuilder.setContentText("Big Picture Notification")
            styleNotificationBuilder.setSmallIcon(android.R.drawable.ic_menu_camera)

            val styleNotificationBigPictureStyle = NotificationCompat.BigPictureStyle(styleNotificationBuilder)
            val bitmap = BitmapFactory.decodeResource(resources, R.drawable.img_android)
            styleNotificationBigPictureStyle.bigPicture(bitmap)
            styleNotificationBigPictureStyle.setSummaryText("Summary Text")

            val styleNotification = styleNotificationBuilder.build()
            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.notify(10, styleNotification)
        }

        /**
         * Big Text Notification
         */
        binding.button2.setOnClickListener {
            val styleNotificationBuilder = getNotificationBuilder("style", "Style Notification")
            styleNotificationBuilder.setContentTitle("Big Text")
            styleNotificationBuilder.setContentText("This is Bing Text Notification")
            styleNotificationBuilder.setSmallIcon(android.R.drawable.ic_menu_camera)

            val styleNotificationBigTextStyle = NotificationCompat.BigTextStyle(styleNotificationBuilder)
            styleNotificationBigTextStyle.setSummaryText("Summary Text")
            styleNotificationBigTextStyle.setBigContentTitle("Big Content Title")
            styleNotificationBigTextStyle.bigText("동해물과 백두산이 마르고 닳도록 하느님이 보우하사 우리나라 만세")

            val styleNotification = styleNotificationBuilder.build()
            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.notify(20, styleNotification)
        }

        /**
         * InBox Style Notification
         */
        binding.button3.setOnClickListener {
            val styleNotificationBuilder = getNotificationBuilder("style", "Style Notification")
            styleNotificationBuilder.setContentTitle("InBox")
            styleNotificationBuilder.setContentText("This is InBox Notification.")
            styleNotificationBuilder.setSmallIcon(android.R.drawable.ic_menu_camera)

            val inbox = NotificationCompat.InboxStyle(styleNotificationBuilder)
            inbox.setSummaryText("Summary Text")
            inbox.addLine("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")
            inbox.addLine("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb")
            inbox.addLine("ccccccccccccccccccccccccccccccccccccccccccc")
            inbox.addLine("ddddddddddddddddddddddddddddddddddddddddddd")
            inbox.addLine("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee")
            inbox.addLine("fffffffffffffffffffffffffffffffffffffffffff")
            inbox.addLine("ggggggggggggggggggggggggggggggggggggggggggg")

            val styleNotification = styleNotificationBuilder.build()
            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.notify(30, styleNotification)
        }

    }

    private fun getNotificationBuilder(id:String,name:String) : NotificationCompat.Builder {
        return if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationManger = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            val notificationChannel = NotificationChannel(id, name, NotificationManager.IMPORTANCE_HIGH)
            notificationChannel.enableLights(true)
            notificationChannel.lightColor = Color.RED
            notificationChannel.enableVibration(true)
            notificationManger.createNotificationChannel(notificationChannel)

            val builder = NotificationCompat.Builder(this, id)
            builder
        } else {
            val builder = NotificationCompat.Builder(this, id)
            builder
        }
    }
}