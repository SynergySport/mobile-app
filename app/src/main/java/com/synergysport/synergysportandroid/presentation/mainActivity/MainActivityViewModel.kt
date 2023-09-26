package com.synergysport.synergysportandroid.presentation.mainActivity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.synergysport.synergysportandroid.domain.TokenDataHandler
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(
    private val tokenDataHandler: TokenDataHandler
) : ViewModel() {

    private val _isAuthorizedLiveData = MutableLiveData<Boolean>()
    val isAuthorizedLiveData: LiveData<Boolean>
        get() = _isAuthorizedLiveData

    fun checkUserAuthorized() {
        _isAuthorizedLiveData.value = tokenDataHandler.isTokenNotEmpty()
    }
}