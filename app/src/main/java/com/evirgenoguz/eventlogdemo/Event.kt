package com.evirgenoguz.eventlogdemo

open class Event(val name: String) {
    open val params: HashMap<String, String>? = null
}