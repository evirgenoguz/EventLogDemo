package com.evirgenoguz.eventlogdemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class FirstFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<View>(R.id.buttonToSecondFragment).setOnClickListener {
            EventLoggerDispatcher.logCustomEvent(CustomNavigateSecondButtonClickEvent())
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, SecondFragment())
                .addToBackStack(null)
                .commit()
        }
    }
}