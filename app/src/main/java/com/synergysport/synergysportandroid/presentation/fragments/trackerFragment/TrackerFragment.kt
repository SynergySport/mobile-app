package com.synergysport.synergysportandroid.presentation.fragments.trackerFragment

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.synergysport.synergysportandroid.R
import com.synergysport.synergysportandroid.SynergySportApp
import javax.inject.Inject

class TrackerFragment : Fragment(R.layout.fragment_tracker) {

    @Inject
    lateinit var viewModel: TrackerFragmentViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity().application as SynergySportApp).appComponent.inject(this)
        initViews()
        bindViewModel()
        viewModel.init()
    }

    private fun initViews() {
        requireView().findViewById<ImageView>(R.id.pause_button).setOnClickListener {
            viewModel.onClickPauseResume()
        }
    }

    private fun bindViewModel() {
        with(viewModel) {
            stepsCountLiveData.observe(viewLifecycleOwner) {
                requireView().findViewById<TextView>(R.id.current_metric_value).text = it.toString()
            }
            onPausedLiveData.observe(viewLifecycleOwner) {
                requireView().findViewById<ImageView>(R.id.pause_button)
                    .setImageResource(if (it) R.drawable.ic_play else R.drawable.ic_pause)
            }
        }
    }

}