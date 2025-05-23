package com.evirgenoguz.eventlogdemo

import android.R.attr.name
import android.util.Log

class ConsoleEventLogger : EventLogger {

    companion object {
        private const val TAG = "ConsoleEventLogger"
    }

    override fun logCustomEvent(event: Event) {
        Log.d(TAG, "Custom Event Logged: ${event.name}\nParams: ${event.params.orEmpty()}")
    }

    override fun logScreen(screenName: String, screenClass: String?) {
        Log.d(TAG, "Screen View Logged: screenName=$screenName, screenClass=$screenClass")
    }

    override fun setUserProperty(key: String, value: String) {
        Log.d(TAG, "User Property Set: $key = $value")
    }

    override fun setUserId(userId: String?) {
        Log.d(TAG, "User ID Set: $userId")
    }
}