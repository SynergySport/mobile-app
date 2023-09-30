package com.synergysport.synergysportandroid.presentation.fragments.trackerFragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.synergysport.synergysportandroid.R

class TrackerFragment : Fragment(R.layout.fragment_tracker) {

    private lateinit var stepTracker: StepTracker

    @SuppressLint("CheckResult")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        stepTracker = StepTrackerImpl(requireContext())
        stepTracker.start()
        stepTracker.listen().subscribe{
            requireView().findViewById<TextView>(R.id.current_metric_value).text = it.toString()
        }

    }

}