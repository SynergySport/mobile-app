package com.synergysport.synergysportandroid.presentation.fragments.profileFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.synergysport.synergysportandroid.domain.entity.Profile
import com.synergysport.synergysportandroid.domain.useCase.GetProfileInfoUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ProfileFragmentViewModel @Inject constructor(
    private val getProfileInfoUseCase: GetProfileInfoUseCase
) : ViewModel() {

    private val _profileInfoLiveData = MutableLiveData<Profile>()
    val profileInfoLiveData: LiveData<Profile>
        get() = _profileInfoLiveData

    private val disposables = CompositeDisposable()

    fun init() {
        disposables.add(
            getProfileInfoUseCase.getProfileInfo().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe({
                _profileInfoLiveData.value = it
            }, {
                it.printStackTrace()
            })
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }
}