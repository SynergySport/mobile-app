package com.synergysport.synergysportandroid.presentation.fragments.trackerFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.synergysport.synergysportandroid.domain.entity.ActivityItem
import com.synergysport.synergysportandroid.domain.entity.MetricData
import com.synergysport.synergysportandroid.domain.useCase.GetActivitiesUseCase
import com.synergysport.synergysportandroid.domain.useCase.SendMetricsUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.text.SimpleDateFormat
import java.util.Calendar
import javax.inject.Inject

class TrackerFragmentViewModel @Inject constructor(
    private val stepTracker: StepTracker,
    private val timerTracker: TimerTracker,
    private val sendMetricsUseCase: SendMetricsUseCase,
    private val getActivitiesUseCase: GetActivitiesUseCase
) : ViewModel() {

    private val _stepsCountLiveData = MutableLiveData<Int>()
    val stepsCountLiveData: LiveData<Int>
        get() = _stepsCountLiveData

    private val _timeCountLiveData = MutableLiveData<Long>()
    val timeCountLiveData: LiveData<Long>
        get() = _timeCountLiveData

    private val _onPausedLiveData = MutableLiveData(false)
    val onPausedLiveData: LiveData<Boolean>
        get() = _onPausedLiveData

    private val _closeScreenLiveData = MutableLiveData<Unit>()
    val closeScreenLiveData: LiveData<Unit>
        get() = _closeScreenLiveData

    private val _setSelectedActivityLiveData = MutableLiveData<ActivityItem>()
    val setSelectedActivityLiveData: LiveData<ActivityItem>
        get() = _setSelectedActivityLiveData

    private val _scoresLiveData = MutableLiveData(0.0)
    val scoresLiveData: LiveData<Double>
        get() = _scoresLiveData

    private val _currentMetricLiveData = MutableLiveData("0")
    val currentMetricLiveData: LiveData<String>
        get() = _currentMetricLiveData

    private val _currentUnitLiveData = MutableLiveData("")
    val currentUnitLiveData: LiveData<String>
        get() = _currentUnitLiveData

    private var startDate = ""

    private val disposables = CompositeDisposable()

    fun init() {
        getActivity()
    }

    fun onClickStop() {
        stepTracker.stop()
        disposables.add(
            sendMetricsUseCase.sendMetrics(
                MetricData(
                    activityId = setSelectedActivityLiveData.value!!.id,
                    startDate = startDate,
                    endDate = getCurrentDate(),
                    countUnit = _scoresLiveData.value!!
                )
            ).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe({
                _closeScreenLiveData.value = Unit
            }, {
                it.printStackTrace()
            })
        )
    }

    fun onClickPauseResume() {
        pauseResumeStepTracker()
        pauseResumeTimerTracker()
        _onPausedLiveData.value = !_onPausedLiveData.value!!
    }

    private fun pauseResumeStepTracker() {
        if (stepTracker.isRunning()) {
            stepTracker.pause()
        } else {
            stepTracker.resume()
        }
    }

    private fun pauseResumeTimerTracker() {
        if (timerTracker.isRunning()) {
            timerTracker.pause()
        } else {
            timerTracker.resume()
        }
    }

    private fun getActivity() {
        disposables.add(
            getActivitiesUseCase.getSelectedActivity().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe({
                    _setSelectedActivityLiveData.value = it
                    proceedActivity(it)
                }, {
                    it.printStackTrace()
                })
        )
    }

    private fun proceedActivity(activityItem: ActivityItem) {
        _currentUnitLiveData.value = activityItem.unit
        startDate = getCurrentDate()
        when (activityItem.unit) {
            UNIT_STEP -> {
                timerTracker.startTimer()
                stepTracker.start()
                disposables.add(stepTracker.listen().subscribe {
                    _stepsCountLiveData.value = it
                    val value = String.format("%.3f", activityItem.costUnit * it).replace(",", ".")
                        .toDouble()
                    _scoresLiveData.value = value
                    _currentMetricLiveData.value = it.toString()
                })
                disposables.add(timerTracker.listen().subscribe {
                    _timeCountLiveData.value = it
                })
            }

            UNIT_KM -> {
                stepTracker.start()
                timerTracker.startTimer()
                disposables.add(stepTracker.listen().subscribe {
                    _stepsCountLiveData.value = it
                    _scoresLiveData.value =
                        String.format("%.3f", activityItem.costUnit * (it * 0.0007))
                            .replace(",", ".").toDouble()
                    _currentMetricLiveData.value = String.format("%.3f", (it * 0.0007))
                })
                disposables.add(timerTracker.listen().subscribe {
                    _timeCountLiveData.value = it
                })
            }

            UNIT_MIN -> {
                timerTracker.startTimer()
                disposables.add(timerTracker.listen().subscribe {
                    _timeCountLiveData.value = it
                    val value = activityItem.costUnit * (it / 1000 / 60.0)
                    _currentMetricLiveData.value =
                        String.format("%.3f", (it / 1000 / 60.0))
                    _scoresLiveData.value =
                        String.format("%.3f", value).replace(",", ".").toDouble()
                })
            }
        }
    }

    private fun getCurrentDate(): String {
        val currentDateTime: Calendar = Calendar.getInstance()
        val formatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
        return formatter.format(currentDateTime.time)
    }

    override fun onCleared() {
        super.onCleared()
        disposables.dispose()
    }

    companion object {
        private const val UNIT_STEP = "step"
        private const val UNIT_KM = "km"
        private const val UNIT_MIN = "min"
    }
}