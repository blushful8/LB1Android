package com.example.lb1android

import android.app.Activity
import android.content.Intent
import android.os.Handler
import android.os.Looper

class ActivityStarter : ActivityState {
    private lateinit var handler: Handler

    private fun initHandler() = Handler(Looper.getMainLooper())

    override fun <T> startMyActivity(activity: T) {
        handler = initHandler()
        handler.postDelayed({
            activity as Activity
            activity.apply {
                val intent by lazy {
                    Intent(this, SecondaryActivity::class.java)
                }
                startActivity(intent)
                finishMyActivity(this@apply)
            }
        }, 2000)
    }

    override fun <T> finishMyActivity(activity: T) {
        (activity as Activity).finish()
    }
}