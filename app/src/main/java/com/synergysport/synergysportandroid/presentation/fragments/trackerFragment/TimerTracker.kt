package com.synergysport.synergysportandroid.presentation.fragments.trackerFragment

import io.reactivex.subjects.Subject

interface TimerTracker {
    fun startTimer()
    fun stopTimer()
    fun pause()
    fun resume()
    fun listen(): Subject<Long>
    fun isRunning(): Boolean
}