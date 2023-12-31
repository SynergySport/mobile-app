package com.synergysport.synergysportandroid.presentation.common

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.synergysport.synergysportandroid.R

object Navigator {
    fun navigateReplace(fragment: Fragment, fragmentManager: FragmentManager) {
        fragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

    fun navigateReplaceSaveStack(fragment: Fragment, fragmentManager: FragmentManager) {
        fragmentManager
            .beginTransaction()
            .addToBackStack(null)
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

    fun closeFragment(fragmentManager: FragmentManager) {
        fragmentManager.popBackStack()
    }
}