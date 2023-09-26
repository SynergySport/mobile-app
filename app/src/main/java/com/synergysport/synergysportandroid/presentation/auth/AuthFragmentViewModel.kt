package com.synergysport.synergysportandroid.presentation.auth

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.synergysport.synergysportandroid.data.dto.UserData
import com.synergysport.synergysportandroid.domain.AuthUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class AuthFragmentViewModel @Inject constructor(private var authUseCase: AuthUseCase) :
    ViewModel() {

    private val _onClickAuthLiveData = MutableLiveData<Unit>()
    val onClickAuthLiveData: LiveData<Unit>
        get() = _onClickAuthLiveData

    @SuppressLint("CheckResult")
    fun onClickAuth(username: String, password: String) {
        val userData = UserData(username, password)
        authUseCase.auth(userData).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).subscribe({
                _onClickAuthLiveData.value = Unit
            }, {
                it.printStackTrace()
            })

    }
}