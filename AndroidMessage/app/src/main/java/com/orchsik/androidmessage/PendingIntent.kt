package com.orchsik.androidmessage

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import com.orchsik.androidmessage.databinding.PendingIntentBinding

/**
 * Notification 메시지를 통해 애플리케이션의 Activity를 실행할 수 있으며
 * 이 때 Pending Intent 사용한다.
 * Pending Intent를 통해 실행되는 Activity로 데이터를 전달할 수 있다.
 */
class PendingIntent : AppCompatActivity() {
    private lateinit var binding: PendingIntentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = PendingIntentBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.button.setOnClickListener {
            val builder1 = getNotificationBuilder("pending", "pending intent")
            builder1.setContentTitle("notification 1")
            builder1.setContentText("This is notification 1")
            builder1.setSmallIcon(android.R.drawable.ic_menu_search)
            val bitmap = BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher)
            builder1.setLargeIcon(bitmap)
            // 메시지를 터치하면 자동으로 알림 사라짐
            builder1.setAutoCancel(true)

            // 메시지를 터치하면 실행할 Activity를 관리할 Intent 생성
            val intent1 = Intent(this, NotificationActivity1::class.java)
            // 다른 Activity로 데이터 전달
            intent1.putExtra("data1", 100)
            intent1.putExtra("data2", 200)

            val pending = PendingIntent.getActivity(this, 10, intent1, PendingIntent.FLAG_UPDATE_CURRENT)
            builder1.setContentIntent(pending)

            // Action 설정
            val intent2 = Intent(this, NotificationActivity3::class.java)
            val pending2 = PendingIntent.getActivity(this, 100, intent2, PendingIntent.FLAG_UPDATE_CURRENT)
            val builder2 = NotificationCompat.Action.Builder(android.R.drawable.ic_menu_compass, "Action 1", pending2)
            val action2 = builder2.build()
            builder1.addAction(action2)

            val intent3 = Intent(this, NotificationActivity4::class.java)
            val pending3 = PendingIntent.getActivity(this, 100, intent3, PendingIntent.FLAG_UPDATE_CURRENT)
            val builder3 = NotificationCompat.Action.Builder(android.R.drawable.ic_menu_agenda, "Action 2", pending3)
            val action3 = builder3.build()
            builder1.addAction(action3)


            val notification = builder1.build()
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.notify(10, notification)
        }

        binding.button2.setOnClickListener {
            val builder1 = getNotificationBuilder("pending", "pending intent")
            builder1.setContentTitle("notification 2")
            builder1.setContentText("This is notification 2")
            builder1.setSmallIcon(android.R.drawable.ic_menu_search)
            val bitmap = BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher)
            builder1.setLargeIcon(bitmap)
            // 메시지를 터치하면 자동으로 알림 사라짐
            builder1.setAutoCancel(true)

            // 메시지를 터치하면 실행할 Activity를 관리할 Intent 생성
            val intent1 = Intent(this, NotificationActivity2::class.java)
            val pending = PendingIntent.getActivity(this, 10, intent1, PendingIntent.FLAG_UPDATE_CURRENT)
            builder1.setContentIntent(pending)

            val notification = builder1.build()
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.notify(20, notification)
        }
    }

    private fun getNotificationBuilder(id:String,name:String) : NotificationCompat.Builder {
        return if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(id, name, NotificationManager.IMPORTANCE_HIGH)
            channel.enableLights(true)
            channel.lightColor = Color.RED
            channel.enableVibration(true)

            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel)

            val builder = NotificationCompat.Builder(this, id)
            builder
        } else {
            val builder = NotificationCompat.Builder(this, id)
            builder
        }
    }
}