package com.synergysport.synergysportandroid.presentation.fragments.trackerFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.synergysport.synergysportandroid.domain.entity.MetricData
import com.synergysport.synergysportandroid.domain.useCase.SendMetricsUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class TrackerFragmentViewModel @Inject constructor(
    private val stepTracker: StepTracker,
    private val sendMetricsUseCase: SendMetricsUseCase
) : ViewModel() {

    private val _stepsCountLiveData = MutableLiveData<Int>()
    val stepsCountLiveData: LiveData<Int>
        get() = _stepsCountLiveData

    private val _onPausedLiveData = MutableLiveData<Boolean>()
    val onPausedLiveData: LiveData<Boolean>
        get() = _onPausedLiveData

    private val _closeScreenLiveData = MutableLiveData<Unit>()
    val closeScreenLiveData: LiveData<Unit>
        get() = _closeScreenLiveData

    private val disposables = CompositeDisposable()

    fun init() {
        stepTracker.start()
        disposables.add(stepTracker.listen().subscribe {
            _stepsCountLiveData.value = it
        })
    }

    fun onClickStop() {
        stepTracker.stop()
        disposables.add(
            sendMetricsUseCase.sendMetrics(
                MetricData(
                    activityId = 2,
                    startDate = "2023-09-25T20:50:55Z",
                    endDate = "2023-09-25T20:50:55Z",
                    countUnit = 10.0
                )
            ).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe({
                _closeScreenLiveData.value = Unit
            }, {
                it.printStackTrace()
            })
        )
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