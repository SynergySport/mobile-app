package com.synergysport.synergysportandroid.presentation.fragments.trainingsFragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.synergysport.synergysportandroid.R
import com.synergysport.synergysportandroid.domain.entity.Training

class TrainingsFragment : Fragment(R.layout.fragment_trainings) {

    private lateinit var trainingsListAdapter: TrainingsListAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView(view)
    }

    private fun initRecyclerView(view: View) {
        val trainingsRv = view.findViewById<RecyclerView>(R.id.trainings_rv)
        trainingsListAdapter = TrainingsListAdapter()
        with(trainingsRv) {
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