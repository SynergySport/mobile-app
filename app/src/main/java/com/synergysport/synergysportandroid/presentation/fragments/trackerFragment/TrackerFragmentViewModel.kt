package com.synergysport.synergysportandroid.presentation.fragments.trackerFragment

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class TrackerFragmentViewModel @Inject constructor(
    private val stepTracker: StepTracker
) : ViewModel() {

    private val _stepsCountLiveData = MutableLiveData<Int>()
    val stepsCountLiveData: LiveData<Int>
        get() = _stepsCountLiveData

    private val _onPausedLiveData = MutableLiveData<Boolean>()
    val onPausedLiveData: LiveData<Boolean>
        get() = _onPausedLiveData

    private val disposables = CompositeDisposable()

    fun init() {
        stepTracker.start()
        disposables.add(stepTracker.listen().subscribe {
            _stepsCountLiveData.value = it
            Log.d("TrackerSteps", "steps count: $it")
        })
    }

    fun onClickStop() {
        stepTracker.stop()
    }

    fun onClickPauseResume() {
        if (stepTracker.isRunning()) {
            stepTracker.pause()
            _onPausedLiveData.value = true
        } else {
            stepTracker.resume()
            _onPausedLiveData.value = false
        }
    }

    override fun onCleared() {
        super.onCleared()
        disposables.dispose()
    }
}