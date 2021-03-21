package com.orchsik.threadandservice

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Binder
import android.os.Build
import android.os.IBinder
import android.os.SystemClock
import android.util.Log
import androidx.core.app.NotificationCompat
import kotlin.concurrent.thread

class IPCService : Service() {

    var value = 0
    var isRunning = false
    var binder = LocalBinder()

    // 외부에서 서비스에 접속하면 호출됨
    override fun onBind(intent: Intent): IBinder {
        return binder
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channelId = "service"
            val channel  = NotificationChannel(channelId, "Service", NotificationManager.IMPORTANCE_HIGH)
            channel.enableLights(true)
            channel.lightColor = Color.RED
            channel.enableVibration(true)

            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel)

            val notificationBuilder = NotificationCompat.Builder(this, channelId)
            notificationBuilder.setSmallIcon(android.R.drawable.ic_menu_camera)
            notificationBuilder.setContentTitle("서비스 가동")
            notificationBuilder.setContentText("서비스가 가동중입니다.")

            val notification = notificationBuilder.build()
            startForeground(10, notification)
        }

        isRunning = true
        thread {
            while (isRunning) {
                SystemClock.sleep(500)
                Log.d("test", "value: $value")
                value++
            }
        }

        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
        isRunning = false
    }

    // 변수값 반환
    fun getNumber():Int {
        return value
    }

    // 접속 Activity에서 서비스를 추출하기위해 사용하는 객체
    inner class LocalBinder: Binder() {
        fun getService(): IPCService {
            return this@IPCService
        }
    }
}