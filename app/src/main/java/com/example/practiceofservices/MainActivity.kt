package com.example.practiceofservices

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.media.AudioManager.STREAM_SYSTEM
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore.Audio.Media
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
//    var md:Media=Media
//    var CHANNEL_ID="hello"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        start.setOnClickListener{
            var int=Intent(applicationContext,MyIntentService::class.java)
            startForegroundService(int)
//            DisplayNotification()
//            startService(int)
        }
        end.setOnClickListener{
            var int=Intent(applicationContext,MyIntentService::class.java)
            stopService(int)
        }

    }


//    fun DisplayNotification(){
//
//    var intt=Intent(this,MainActivity::class.java)
//    var pendingintent = PendingIntent.getActivity(this,0,intt,0)
//        // that check is for test if sdk_version is higher than 26
//        //  because we need to work with channels
//        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            val channel = NotificationChannel(CHANNEL_ID, "hellooo", NotificationManager.IMPORTANCE_HIGH)
//            channel.description="this is for description."
//
//            val nm:NotificationManager =getSystemService(NotificationManager::class.java)
//            nm.createNotificationChannel(channel)
//        }
//        // that work do whatever the version of sdk
//        var builder = NotificationCompat.Builder(applicationContext,CHANNEL_ID)
//        builder.setContentText("hhhhhhhhhhhhh")
//            .setSmallIcon(androidx.appcompat.R.drawable.btn_radio_off_mtrl)
//            .setContentTitle("title")
//            .setPriority(NotificationCompat.PRIORITY_HIGH)
//            .setStyle(NotificationCompat.BigTextStyle())
//            .setContentIntent(pendingintent) //use pendingIntent andthe click for hole notification
////            .addAction(androidx.appcompat.R.drawable.btn_radio_off_mtrl,"go to activity",pendingintent)// use PendingIntent in this/& if u need to set the click only in the section of action
////            .setSound()
//
//        var nmc= NotificationManagerCompat.from(this)
//        nmc.notify(19,builder.build())
//    }
}



















