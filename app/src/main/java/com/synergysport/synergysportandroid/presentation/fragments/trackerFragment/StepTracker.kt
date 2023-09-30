package com.synergysport.synergysportandroid.presentation.fragments.trackerFragment

import io.reactivex.subjects.Subject

interface StepTracker {
    fun start()
    fun stop()
    fun pause()
    fun resume()
    fun listen(): Subject<Int>
}