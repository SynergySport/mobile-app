package com.synergysport.synergysportandroid.presentation.fragments.trainingsFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.synergysport.synergysportandroid.R
import com.synergysport.synergysportandroid.SynergySportApp
import com.synergysport.synergysportandroid.databinding.FragmentAuthBinding
import com.synergysport.synergysportandroid.databinding.FragmentTrainingsBinding
import com.synergysport.synergysportandroid.domain.entity.Training
import com.synergysport.synergysportandroid.presentation.auth.AuthFragmentViewModel
import com.synergysport.synergysportandroid.presentation.common.ToolbarVisibilityListener
import com.synergysport.synergysportandroid.presentation.fragments.trainingsFragment.adapter.TrainingsListAdapter
import javax.inject.Inject

class TrainingsFragment : Fragment(R.layout.fragment_trainings) {

    private lateinit var trainingsListAdapter: TrainingsListAdapter

    private lateinit var binding: FragmentTrainingsBinding

    @Inject
    lateinit var viewModel: TrainingsFragmentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireActivity().application as SynergySportApp).appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTrainingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        bindViewModel()
        viewModel.init()
    }

    private fun bindViewModel() {

    }

    private fun initViews() {
        initRecyclerView()
    }

    private fun initRecyclerView() {
        trainingsListAdapter = TrainingsListAdapter()
        with(binding.trainingsRv) {
            adapter = trainingsListAdapter
            trainingsListAdapter.submitList(
                listOf(
                    Training(0, "Бег", "20.12.2020 17:00", 5, "16 min", "100km", "20km/h"),
                    Training(1, "Ходьба", "20.12.2021 17:00", 2, "16 min", "100km", "20km/h"),
                    Training(2, "Спортзал", "20.12.2022 17:00", 8, "16 min", "100km", "20km/h"),
                )
            )
        }
    }
}