package com.example.lb1android

interface ActivityState {
    fun <T> startMyActivity(activity: T)
    fun <T> finishMyActivity(activity: T)
}