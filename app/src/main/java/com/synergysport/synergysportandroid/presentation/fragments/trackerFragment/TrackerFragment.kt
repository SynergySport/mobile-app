package com.synergysport.synergysportandroid.presentation.fragments.trackerFragment

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.synergysport.synergysportandroid.R

class TrackerFragment : Fragment(R.layout.fragment_tracker), SensorEventListener {
    private var sensorManager: SensorManager? = null

    private var running = true

    private var totalSteps = 0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sensorManager = requireContext().getSystemService(Context.SENSOR_SERVICE) as SensorManager
    }

    override fun onResume() {
        super.onResume()
        running = true
        val stepSensor = sensorManager?.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)
        if (stepSensor == null) {
            Toast.makeText(
                requireContext(),
                "No sensor detected on this device",
                Toast.LENGTH_SHORT
            ).show()
        } else {
            sensorManager?.registerListener(this, stepSensor, SensorManager.SENSOR_DELAY_UI)
        }
    }

    override fun onSensorChanged(event: SensorEvent) {
        if (running) {
            requireView().findViewById<TextView>(R.id.current_metric_value).text =
                event.values[0].toInt().toString()
        }
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {

    }
}