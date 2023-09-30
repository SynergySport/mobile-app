package com.synergysport.synergysportandroid.presentation.fragments.selectActivityFragment.adapter

import android.app.Activity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.synergysport.synergysportandroid.domain.useCase.GetActivitiesUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class SelectActivityViewModel @Inject constructor(
    private val getActivitiesUseCase: GetActivitiesUseCase
) : ViewModel() {
    private val _allActivitiesLiveData = MutableLiveData<List<Activity>>()
    val allActivitiesLiveData: LiveData<List<Activity>>
        get() = _allActivitiesLiveData

    private val disposables = CompositeDisposable()

    fun init() {
        getAllActivities()
    }

    private fun getAllActivities() {
        disposables.add(getActivitiesUseCase.getAllActivities().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).subscribe({
                _allActivitiesLiveData.value = it
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