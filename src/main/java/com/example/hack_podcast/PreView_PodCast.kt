package com.example.hack_podcast

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class PreView_PodCast : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pre_view__pod_cast)
    }

    fun open_CompletePodCast(view: View) {
        val intent = Intent(this, Complete_PodCast::class.java).apply{}
        startActivity(intent)
    }

}