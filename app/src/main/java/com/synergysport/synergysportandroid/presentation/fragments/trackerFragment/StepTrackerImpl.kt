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

    override fun start() {
        val stepSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)
        if (stepSensor == null) {
            showError()
            return
        }
        sensorManager.registerListener(this, stepSensor, SensorManager.SENSOR_DELAY_UI)

    }

    override fun stop() {
        sensorManager.unregisterListener(
            this,
            sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)
        )
    }

    override fun pause() {
        sensorManager.unregisterListener(
            this,
            sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)
        )
    }

    override fun resume() {
        start()
    }

    override fun listen(): Subject<Int> = stepsSubject

    override fun onSensorChanged(event: SensorEvent) {
        stepsSubject.onNext(event.values[0].toInt())
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