package com.synergysport.synergysportandroid.presentation.fragments.trackerFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.synergysport.synergysportandroid.R
import com.synergysport.synergysportandroid.SynergySportApp
import com.synergysport.synergysportandroid.databinding.FragmentTrackerBinding
import com.synergysport.synergysportandroid.presentation.common.Navigator
import javax.inject.Inject

class TrackerFragment : Fragment() {

    private lateinit var binding: FragmentTrackerBinding

    @Inject
    lateinit var viewModel: TrackerFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTrackerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity().application as SynergySportApp).appComponent.inject(this)
        initViews()
        bindViewModel()
        viewModel.init()
    }

    private fun initViews() {
        initPauseButton()
        initStopButton()
    }

    private fun initPauseButton() {
        binding.pauseButton.setOnClickListener {
            viewModel.onClickPauseResume()
        }
    }

    private fun initStopButton() {
        with(binding.stopButton) {
            setOnClickListener {
                viewModel.onClickStop()
            }
            isVisible = false
        }
    }

    private fun bindViewModel() {
        with(viewModel) {
            stepsCountLiveData.observe(viewLifecycleOwner) {
                binding.currentMetricValue.text = it.toString()
            }
            onPausedLiveData.observe(viewLifecycleOwner) {
                binding.pauseButton
                    .setImageResource(if (it) R.drawable.ic_play else R.drawable.ic_pause)
                binding.stopButton.isVisible = it
            }
            closeScreenLiveData.observe(viewLifecycleOwner) {
                Navigator.closeFragment(parentFragmentManager)
            }
        }
    }

}