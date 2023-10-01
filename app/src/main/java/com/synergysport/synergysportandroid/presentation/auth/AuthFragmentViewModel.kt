package com.synergysport.synergysportandroid.presentation.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.synergysport.synergysportandroid.data.network.dto.UserData
import com.synergysport.synergysportandroid.domain.useCase.AuthUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class AuthFragmentViewModel @Inject constructor(private var authUseCase: AuthUseCase) :
    ViewModel() {

    private val _onClickAuthLiveData = MutableLiveData<Unit>()
    val onClickAuthLiveData: LiveData<Unit>
        get() = _onClickAuthLiveData

    private val _errorAuthLiveData = MutableLiveData<Unit>()
    val errorAuthLiveData: LiveData<Unit>
        get() = _errorAuthLiveData

    private val disposables = CompositeDisposable()

    fun onClickAuth(username: String?, password: String?) {
        if (username.isNullOrBlank() || password.isNullOrBlank()) {
            _errorAuthLiveData.value = Unit
            return
        }
        val userData = UserData(username, password)
        disposables.add(authUseCase.auth(userData).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).subscribe({
                _onClickAuthLiveData.value = Unit
            }, {
                it.printStackTrace()
            })
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposables.dispose()
    }
}