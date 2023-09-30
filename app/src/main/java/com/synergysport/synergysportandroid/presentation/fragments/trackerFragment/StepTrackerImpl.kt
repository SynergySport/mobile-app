package com.synergysport.synergysportandroid.presentation.fragments.trackerFragment

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.widget.Toast
import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.Subject
import javax.inject.Inject

class StepTrackerImpl @Inject constructor(
    private val context: Context
) : StepTracker, SensorEventListener {

    private var sensorManager: SensorManager =
        context.getSystemService(Context.SENSOR_SERVICE) as SensorManager

    private val stepsSubject: Subject<Int> = PublishSubject.create()

    private var isRunning = false

    private var previousStepsCount: Int? = null
    private var lastPausedStepsCount: Int? = null
    private var lastSavedBeforePauseCount = 0

    override fun start() {
        val stepSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)
        if (stepSensor == null) {
            showError()
            return
        }
        isRunning = true
        sensorManager.registerListener(this, stepSensor, SensorManager.SENSOR_DELAY_UI)
    }

    override fun stop() {

    }

    override fun pause() {
        isRunning = false
    }

    override fun resume() {
        isRunning = true
    }

    override fun listen(): Subject<Int> = stepsSubject

    override fun isRunning() = isRunning

    override fun onSensorChanged(event: SensorEvent) {
        val currentStepsCount = event.values[0].toInt()
        if (!isRunning) {
            lastPausedStepsCount = currentStepsCount
            return
        }
        if (previousStepsCount == null) {
            previousStepsCount = currentStepsCount
        }
        if (lastPausedStepsCount != null) {
            lastSavedBeforePauseCount = lastSavedBeforePauseCount + currentStepsCount - lastPausedStepsCount!!
            stepsSubject.onNext(lastSavedBeforePauseCount)
            return
        }
        lastSavedBeforePauseCount = currentStepsCount - previousStepsCount!!
        stepsSubject.onNext(lastSavedBeforePauseCount)
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {

    }

    private fun showError() {
        Toast.makeText(
            context,
            "No sensor detected on this device",
            Toast.LENGTH_SHORT
        ).show()
    }
}