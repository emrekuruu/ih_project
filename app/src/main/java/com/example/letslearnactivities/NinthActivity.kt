package com.example.letslearnactivities

import android.app.Activity
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.TaskStackBuilder
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class NinthActivity : AppCompatActivity() {

    val CHANNEL_ID = "channelID"
    val CHANNEL_NAME = "channelNAME"
    val NOTIFICATION_ID = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ninth)

        createNotifChannel()

        val intent = Intent(this,TenthActivity::class.java)
        val pendingIntent = TaskStackBuilder.create(this).run {
            addNextIntentWithParentStack(intent)
            getPendingIntent(0,PendingIntent.FLAG_IMMUTABLE)
        }

        val notification = NotificationCompat.Builder(this,CHANNEL_ID)
                .setContentTitle("Disaster")
                .setContentText("There has been a disaster!")
                .setSmallIcon(R.drawable.ic_alert)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setContentIntent(pendingIntent)
                .build()

        val notificationManager = NotificationManagerCompat.from(this)
        findViewById<Button>(R.id.alert).setOnClickListener{
            notificationManager.notify(NOTIFICATION_ID,notification)
        }
    }

    fun createNotifChannel(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val channel = NotificationChannel(CHANNEL_ID,CHANNEL_NAME,
                NotificationManager.IMPORTANCE_DEFAULT).apply {
                    lightColor = Color.RED
                    enableLights(true)
            }
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel)
        }
    }
}