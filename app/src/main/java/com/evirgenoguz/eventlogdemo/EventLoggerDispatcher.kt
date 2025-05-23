package com.evirgenoguz.eventlogdemo

import android.content.Context
import com.google.firebase.analytics.FirebaseAnalytics

object EventLoggerDispatcher : EventLogger {

    val loggers: MutableList<EventLogger> = mutableListOf()

    fun init(context: Context) {
        loggers.add(FirebaseEventLogger(FirebaseAnalytics.getInstance(context)))
        loggers.add(ConsoleEventLogger())
    }

    override fun logCustomEvent(event: Event) {
        loggers.forEach { it.logCustomEvent(event) }
    }

    override fun logScreen(screenName: String, screenClass: String?) {
        loggers.forEach { it.logScreen(screenName, screenClass) }
    }

    override fun setUserProperty(key: String, value: String) {
        loggers.forEach { it.setUserProperty(key, value) }
    }

    override fun setUserId(userId: String?) {
        loggers.forEach { it.setUserId(userId) }
    }
}
