package com.example.practiceofservices

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.Build
import android.os.IBinder
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class MyService : Service() {

    var mp:MediaPlayer?=null

    var CHANNEL_ID="hello"

    override fun onCreate() {
        super.onCreate()
        //set the medis player in oncreate of the services for being knowing & manipulating by the method OnStartCommand
        mp=MediaPlayer.create(this,R.raw.makhna)

    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        startForeground(1,DisplayNotification())
        if(!mp!!.isPlaying)
            //to start the command use method start
            mp!!.start()


        return START_STICKY
    }

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }

    fun DisplayNotification():Notification{

        val intt=Intent(this,MainActivity::class.java)
        val pendingintent = PendingIntent.getActivity(this,0,intt,0)


        // ############### build a channel ###############
        // that check is for test if sdk_version is higher than 26
        //  because we should to work with channel on it ---------->    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val channel = NotificationChannel(CHANNEL_ID, "hellooo", NotificationManager.IMPORTANCE_HIGH)
//        channel.description="this is for description."

        val nm: NotificationManager =getSystemService(NotificationManager::class.java)
        nm.createNotificationChannel(channel)
//        }


        // ############### build a notification ###############
        // that work do whatever the version of sdk
        var builder = NotificationCompat.Builder(applicationContext,CHANNEL_ID)
        builder.setContentText("hhhhhhhhhhhhh")
            .setSmallIcon(androidx.appcompat.R.drawable.btn_radio_off_mtrl)
            .setContentTitle("title")
            .setContentText("that for display a long text if u want to set a lonng discribe text")
            .setPriority(NotificationCompat.PRIORITY_HIGH)//to set the priority to the notification
//            .setStyle(NotificationCompat.BigTextStyle())
            .setContentIntent(pendingintent) //use pendingIntent /set the click for hole notification
//            .addAction(androidx.appcompat.R.drawable.btn_radio_off_mtrl,"go to activity",pendingintent)// use PendingIntent in this /if u need to set the click only in the section of action
//            .setSound()

        return  builder.build()
    }



    override fun onDestroy() {
        super.onDestroy()
        //to stop the command use stop
        mp!!.stop()
        mp!!.release()
    }
}
