package com.tutorials180.clasprojecte4.ServiceWorking

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.media.RingtoneManager
import android.os.IBinder
import android.widget.Toast

class MyMediaService :Service() {

    private lateinit var mMediaPlayer: MediaPlayer

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        mMediaPlayer = MediaPlayer.create(this,RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM))
        mMediaPlayer.isLooping = true

        mMediaPlayer.start()
        Toast.makeText(applicationContext, "Service Start", Toast.LENGTH_SHORT).show();
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        mMediaPlayer.stop()
        Toast.makeText(applicationContext, "Service Stop", Toast.LENGTH_SHORT).show();

    }
    override fun onBind(p0: Intent?): IBinder? {
        return null
    }
}