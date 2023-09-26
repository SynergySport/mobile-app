package com.synergysport.synergysportandroid.presentation.mainActivity

import androidx.lifecycle.ViewModel
import com.synergysport.synergysportandroid.domain.TokenDataHandler
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(
    private val tokenDataHandler: TokenDataHandler
) : ViewModel() {
    fun init() {

    }
}