package com.synergysport.synergysportandroid.presentation.fragments.startTrainingFragment

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.synergysport.synergysportandroid.R
import com.synergysport.synergysportandroid.presentation.common.Navigator
import com.synergysport.synergysportandroid.presentation.fragments.selectActivityFragment.SelectActivityFragment
import com.synergysport.synergysportandroid.presentation.fragments.trackerFragment.TrackerFragment

class StartTrainingFragment : Fragment(R.layout.fragment_start_training) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        initStartTrackerButton()
        initSelectActivityTypeButton()
    }

    private fun initStartTrackerButton() {
        requireView().findViewById<TextView>(R.id.start_tracker_button).setOnClickListener {
            Navigator.navigateReplaceSaveStack(TrackerFragment(), parentFragmentManager)
        }
    }

    private fun initSelectActivityTypeButton() {
        requireView().findViewById<ImageView>(R.id.select_activity_type_button).setOnClickListener {
            Navigator.navigateReplaceSaveStack(SelectActivityFragment(), parentFragmentManager)
        }
    }
}