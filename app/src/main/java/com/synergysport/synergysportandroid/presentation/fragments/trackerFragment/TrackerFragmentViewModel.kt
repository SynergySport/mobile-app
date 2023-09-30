package com.synergysport.synergysportandroid.presentation.fragments.trackerFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class TrackerFragmentViewModel @Inject constructor(
    private val stepTracker: StepTracker
): ViewModel() {
    private val _stepsCountLiveData = MutableLiveData<Int>()
    val stepsCountLiveData: LiveData<Int>
        get() = _stepsCountLiveData

    private val disposables = CompositeDisposable()

    fun init() {
        stepTracker.start()
        disposables.add(stepTracker.listen().subscribe {
            _stepsCountLiveData.value = it
        })
    }

    fun onClickResume() {
        stepTracker.resume()
    }

    fun onClickStop() {
        stepTracker.stop()
    }

    fun onClickPause() {
        stepTracker.pause()
    }

    override fun onCleared() {
        super.onCleared()
        disposables.dispose()
    }
}