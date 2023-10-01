package com.synergysport.synergysportandroid.presentation.fragments.trainingsFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.synergysport.synergysportandroid.domain.entity.Training
import com.synergysport.synergysportandroid.domain.useCase.GetTrainingsUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class TrainingsFragmentViewModel @Inject constructor(
    private val getTrainingsUseCase: GetTrainingsUseCase
) : ViewModel() {

    private val _trainingsLiveData = MutableLiveData<List<Training>>()
    val trainingsLiveData: LiveData<List<Training>>
        get() = _trainingsLiveData

    private val disposables = CompositeDisposable()

    fun init() {
        disposables.add(
            getTrainingsUseCase.getTrainings().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe({
                    _trainingsLiveData.value = it
                }, {
                    it.printStackTrace()
                })
        )
    }
}