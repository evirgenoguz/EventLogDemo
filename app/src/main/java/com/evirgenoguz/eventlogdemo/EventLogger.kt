package com.evirgenoguz.eventlogdemo

interface EventLogger {
    fun logCustomEvent(event: Event)
    fun logScreen(screenName: String, screenClass: String? = null)
    fun setUserProperty(key: String, value: String)
    fun setUserId(userId: String?)
}