package com.example.fcm

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.fcm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var text: EditText
    private lateinit var btn: Button
    private lateinit var notificationManager: NotificationManager
    private lateinit var notificationChannel: NotificationChannel
    private lateinit var builder: Notification.Builder
    private val channelId = "myapp.notifications"
    private val description = "Notification App Example"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn = findViewById(R.id.showBtn)
        text = findViewById(R.id.notifyText)


        btn.setOnClickListener { NotifyBtn() }

    }
    private fun NotifyBtn() {
        notificationManager = getSystemService(AppCompatActivity.NOTIFICATION_SERVICE) as NotificationManager
        val pendingIntent =
            PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationChannel =
                NotificationChannel(
                    channelId,
                    description,
                    NotificationManager.IMPORTANCE_HIGH
                )
            notificationManager.createNotificationChannel(notificationChannel)

            builder = Notification.Builder(this, channelId)
                .setSmallIcon(R.drawable.ic_baseline_notifications_24)
                .setLargeIcon(
                    BitmapFactory.decodeResource(
                        this.resources,
                        R.drawable.ic_baseline_notifications_24
                    )
                )
                .setContentIntent(pendingIntent)
                .setContentTitle("Notification")
                .setContentText(text.text!!.toString())
            notificationManager.notify(12, builder.build())
        } else {

            builder = Notification.Builder(this)
                .setSmallIcon(R.drawable.ic_baseline_notifications_24)
                .setLargeIcon(
                    BitmapFactory.decodeResource(
                        this.resources,
                        R.drawable.ic_baseline_notifications_24
                    )
                )
                .setContentIntent(pendingIntent)
                .setContentTitle("Notification")
                .setContentText(text.text!!.toString())
            notificationManager.notify(12, builder.build())
        }
    }
}
