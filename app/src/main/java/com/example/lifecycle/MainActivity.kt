package com.example.lifecycle

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    private var mediaPlayer:MediaPlayer? = null

    private var position: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        Log.i("Lifecycle", "OnCreate")
    }

    override fun onStart() {
        super.onStart()
        mediaPlayer = MediaPlayer.create(this, R.raw.ai_2)
        Log.i("Lifecycle", "OnStart")
    }

    override fun onResume() {
        super.onResume()
        mediaPlayer?.seekTo(position)
        mediaPlayer?.start()
        Log.i("Lifecycle", "OnResume")
    }

    override fun onPause() {
        super.onPause()
        mediaPlayer?.pause()
        if(mediaPlayer != null)
            position = mediaPlayer!!.currentPosition

        Log.i("Lifecycle", "OnPause")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("Lifecycle", "OnDestroy")
    }

    override fun onStop() {
        super.onStop()
        mediaPlayer?.stop()
        mediaPlayer?.release()
        mediaPlayer = null
        Log.i("Lifecycle", "OnStop")
    }

}