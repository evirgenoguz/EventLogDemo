package com.evirgenoguz.eventlogdemo

import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {

    override fun onResume() {
        super.onResume()
        setLogScreen()
    }

    private fun setLogScreen() {
        val screenName = this::class.java.simpleName
        EventLoggerDispatcher.logScreen(screenName, screenName)
    }
}