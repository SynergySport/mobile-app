package com.synergysport.synergysportandroid.presentation.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.synergysport.synergysportandroid.data.AuthRepositoryImpl
import com.synergysport.synergysportandroid.domain.AuthUseCase

class AuthFragmentViewModel : ViewModel() {

    private val authUseCase: AuthUseCase = AuthUseCase(AuthRepositoryImpl())

    private val _onClickAuthLiveData = MutableLiveData<Unit>()
    val onClickAuthLiveData: LiveData<Unit>
        get() = _onClickAuthLiveData

    fun onClickAuth() {
        authUseCase.auth()
        _onClickAuthLiveData.value = Unit
    }
}