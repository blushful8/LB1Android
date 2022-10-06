package com.example.lb1android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val activityStarter = ActivityStarter()
        window.addFlags(1024)
        activityStarter.startMyActivity(this)
    }
}