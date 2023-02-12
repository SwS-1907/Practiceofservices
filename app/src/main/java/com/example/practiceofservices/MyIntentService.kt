package com.example.practiceofservices

import android.app.*
import android.content.Intent
import android.content.Context
import androidx.core.app.NotificationCompat

class MyIntentService : IntentService("MyIntentService") {

    var CHANNEL_ID="chan_id"

    override fun onHandleIntent(intent: Intent?) {

        startForeground(1,DisplayNotification())

    }

    fun DisplayNotification(): Notification {

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


}
