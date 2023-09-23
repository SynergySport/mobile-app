package com.synergysport.synergysportandroid.presentation.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AuthFragmentViewModel : ViewModel() {

    private val _onClickAuthLiveData = MutableLiveData<Unit>()
    val onClickAuthLiveData: LiveData<Unit>
        get() = _onClickAuthLiveData

    fun onClickAuth() {
        _onClickAuthLiveData.value = Unit
    }
}