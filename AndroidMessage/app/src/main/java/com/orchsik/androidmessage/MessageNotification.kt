package com.orchsik.androidmessage

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.core.app.Person
import androidx.core.graphics.drawable.IconCompat
import com.orchsik.androidmessage.databinding.MessageNotificationBinding

/**
 * 안드로이드 9.0에서 새롭게 추가된 Notification
 * 다자간 메시지 내용을 표시하는 용도로 사용.
 */
class MessageNotification : AppCompatActivity() {
    private lateinit var binding: MessageNotificationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MessageNotificationBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        /**
         * 다자간 채팅을 나누는것 같은 형태의 알림.
         */
        binding.button.setOnClickListener {
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                val messageNotificationBuilder = getNotificationBuilder("message", "Message Style")
                messageNotificationBuilder.setContentTitle("Message Style")
                messageNotificationBuilder.setContentText("This is Message Style")
                messageNotificationBuilder.setSmallIcon(android.R.drawable.ic_input_delete)

                val personBuilder1 = Person.Builder()
                val icon1 = IconCompat.createWithResource(this, R.drawable.imgflag1)
                personBuilder1.setIcon(icon1)
                personBuilder1.setName("Lee")
                val person1 = personBuilder1.build()

                val personBuilder2 = Person.Builder()
                val icon2 = IconCompat.createWithResource(this, R.drawable.imgflag2)
                personBuilder2.setIcon(icon2)
                personBuilder2.setName("Kim")
                val person2 = personBuilder2.build()

                val messageStyle = NotificationCompat.MessagingStyle(person1)
                messageStyle.addMessage("first message", System.currentTimeMillis(), person1)
                messageStyle.addMessage("second message", System.currentTimeMillis(), person2)
                messageStyle.addMessage("third message", System.currentTimeMillis(), person2)
                messageStyle.addMessage("forth message", System.currentTimeMillis(), person1)

                messageNotificationBuilder.setStyle(messageStyle)

                val messageNotification = messageNotificationBuilder.build()
                val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
                notificationManager.notify(10, messageNotification)
            }
        }
    }

    private fun getNotificationBuilder(id:String, name:String) : NotificationCompat.Builder {
        return if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(id, name, NotificationManager.IMPORTANCE_HIGH)
            channel.enableVibration(true)
            channel.enableLights(true)
            channel.lightColor = Color.RED

            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)

            val builder = NotificationCompat.Builder(this, id)
            builder
        } else {
            val builder = NotificationCompat.Builder(this, id)
            builder
        }
    }
}