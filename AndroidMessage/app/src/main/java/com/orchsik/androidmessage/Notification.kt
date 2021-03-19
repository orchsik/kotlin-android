package com.orchsik.androidmessage

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import com.orchsik.androidmessage.databinding.NotificaitonBinding

/**
 * 안드로이드 8.0부터 새롭게 추가된 기능
 * 이전에는 애플리케이션 단위로 알림메시지를 활성화 여부를 설정했다.
 * 8.0부터는 동일 애플리케이션 내에서 알림 활성여부를 Channel로 묶어서 관리할 수 있다.
 */
class Notification : AppCompatActivity() {
    private lateinit var binding: NotificaitonBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = NotificaitonBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        /**
         * channel: channel1 / id: 10
         */
        binding.button.setOnClickListener {
            val builder1 = getNotificationBuilder("channel1", "First Channel")
            // 작은 아이콘(메시지 수신지 상단에 보여줄 작은 아이콘
            builder1.setSmallIcon(android.R.drawable.ic_menu_search)
            // 큰 아이콘(메시지 본문에 표시할 메시지. Bitmap 객체)
            val bitmap = BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher)
            builder1.setLargeIcon(bitmap)
            // 숫자 설정
            builder1.setNumber(100)
            // 타이틀 설정
            builder1.setContentTitle("Content Title")
            // 메시지 설정
            builder1.setContentText("Content Text")

            // 메시지 객체 생성
            val notification = builder1.build()
            // 알림 메시지를 관리하는 객체 추출
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            // 알림 메시지 출력 / id를 다르게 줘야 알림이 따로 쌓임.
            manager.notify(10, notification)
        }

        /**
         * channel: channel1 / id: 20
         */
        binding.button2.setOnClickListener {
            val builder1 = getNotificationBuilder("channel1", "First Channel")
            // 작은 아이콘(메시지 수신지 상단에 보여줄 작은 아이콘
            builder1.setSmallIcon(android.R.drawable.ic_menu_search)
            // 큰 아이콘(메시지 본문에 표시할 메시지. Bitmap 객체)
            val bitmap = BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher)
            builder1.setLargeIcon(bitmap)
            // 숫자 설정
            builder1.setNumber(100)
            // 타이틀 설정
            builder1.setContentTitle("Content Title 2")
            // 메시지 설정
            builder1.setContentText("Content Text 2")

            // 메시지 객체 생성
            val notification = builder1.build()
            // 알림 메시지를 관리하는 객체 추출
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            // 알림 메시지 출력
            manager.notify(20, notification)
        }

        /**
         * channel: channel2 / id: 30
         */
        binding.button3.setOnClickListener {
            val builder1 = getNotificationBuilder("channel2", "Second Channel")
            // 작은 아이콘(메시지 수신지 상단에 보여줄 작은 아이콘
            builder1.setSmallIcon(android.R.drawable.ic_menu_search)
            // 큰 아이콘(메시지 본문에 표시할 메시지. Bitmap 객체)
            val bitmap = BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher)
            builder1.setLargeIcon(bitmap)
            // 숫자 설정
            builder1.setNumber(100)
            // 타이틀 설정
            builder1.setContentTitle("Content Title 3")
            // 메시지 설정
            builder1.setContentText("Content Text 3")

            // 메시지 객체 생성
            val notification = builder1.build()
            // 알림 메시지를 관리하는 객체 추출
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            // 알림 메시지 출력
            manager.notify(30, notification)
        }

        /**
         * channel: channel2 / id: 40
         */
        binding.button4.setOnClickListener {
            val builder1 = getNotificationBuilder("channel2", "Second Channel")
            // 작은 아이콘(메시지 수신지 상단에 보여줄 작은 아이콘
            builder1.setSmallIcon(android.R.drawable.ic_menu_search)
            // 큰 아이콘(메시지 본문에 표시할 메시지. Bitmap 객체)
            val bitmap = BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher)
            builder1.setLargeIcon(bitmap)
            // 숫자 설정
            builder1.setNumber(100)
            // 타이틀 설정
            builder1.setContentTitle("Content Title 4")
            // 메시지 설정
            builder1.setContentText("Content Text 4")

            // 메시지 객체 생성
            val notification = builder1.build()
            // 알림 메시지를 관리하는 객체 추출
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            // 알림 메시지 출력
            manager.notify(40, notification)
        }

        /**
         * 8.0 이전에서만 사용 가능
         */
        /*binding.button.setOnClickListener {
            val builder = NotificationCompat.Builder(this)

            builder.setSmallIcon(android.R.drawable.ic_menu_search)
            val bitmap = BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher)
            builder.setLargeIcon(bitmap)

            builder.setContentTitle("Content Title")
            builder.setContentText("Content Text")

            val notification = builder.build()
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.notify(10, notification)
        }*/
    }


    /**
     * 모든 버전에서 사용 가능
     */
    private fun getNotificationBuilder(id:String, name:String) : NotificationCompat.Builder {
        // OS 버전별로 분기
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // 알림 메시지 관리 객체 추출
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

            // 채널 객체 생성
            val channel = NotificationChannel(id, name, NotificationManager.IMPORTANCE_HIGH)
            // 단말기 LED 여부
            channel.enableLights(true)
            channel.lightColor = Color.RED
            // 진동 사용 여부
            channel.enableVibration(true)

            // 알림 메시지 관리 객체에 채널 등록
            manager.createNotificationChannel(channel)

            val builder = NotificationCompat.Builder(this, id)
            return builder
        } else {
            val builder = NotificationCompat.Builder(this)
            return builder
        }
    }

}