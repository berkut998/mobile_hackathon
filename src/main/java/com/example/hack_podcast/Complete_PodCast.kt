package com.example.hack_podcast

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Complete_PodCast : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_complete__pod_cast)
    }

    fun open_ToBegin(view: View) {
        val intent = Intent(this, MainActivity::class.java).apply{}
        startActivity(intent)
    }
}