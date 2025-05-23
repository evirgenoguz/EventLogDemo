package com.evirgenoguz.eventlogdemo

import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics

class FirebaseEventLogger(private val analytics: FirebaseAnalytics) : EventLogger {

    override fun logCustomEvent(event: Event) {
        val bundle = Bundle().apply {
            event.params.orEmpty().forEach { (key, value) ->
                putString(key, value)
            }
        }
        analytics.logEvent(event.name, bundle)
    }

    override fun logScreen(screenName: String, screenClass: String?) {
        val bundle = Bundle().apply {
            putString(FirebaseAnalytics.Param.SCREEN_NAME, screenName)
            putString(FirebaseAnalytics.Param.SCREEN_CLASS, screenClass ?: "DefaultScreen")
        }
        analytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW, bundle)
    }

    override fun setUserProperty(key: String, value: String) {
        analytics.setUserProperty(key, value)
    }

    override fun setUserId(userId: String?) {
        analytics.setUserId(userId)
    }
}