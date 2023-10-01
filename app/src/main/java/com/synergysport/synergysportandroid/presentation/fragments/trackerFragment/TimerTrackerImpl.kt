package com.synergysport.synergysportandroid.presentation.fragments.trackerFragment

import android.os.CountDownTimer
import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.Subject
import javax.inject.Inject

class TimerTrackerImpl @Inject constructor() : TimerTracker, CountDownTimer(Long.MAX_VALUE, 1000) {

    private val timeSubject: Subject<Long> = PublishSubject.create()
    private var elapsedTime = 0L
    private var isRunning = false

    override fun startTimer() {
        isRunning = true
        start()
    }

    override fun onTick(p0: Long) {
        elapsedTime += 1000
        timeSubject.onNext(elapsedTime)
    }

    override fun onFinish() {
        isRunning = false
        timeSubject.onComplete()
    }

    override fun stopTimer() {
        isRunning = false
        cancel()
    }

    override fun pause() {
        isRunning = false
        cancel()
    }

    override fun resume() {
        isRunning = true
        start()
    }

    override fun listen(): Subject<Long> = timeSubject

    override fun isRunning() = isRunning


}