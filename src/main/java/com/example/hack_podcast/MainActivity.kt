package com.example.hack_podcast

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun open_CreateNEwPodCast(view: View) {
        val intent = Intent(this, CreateNewPodcast::class.java).apply{}
        startActivity(intent)
    }
}