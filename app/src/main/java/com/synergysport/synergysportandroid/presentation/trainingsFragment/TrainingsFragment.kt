package com.synergysport.synergysportandroid.presentation.trainingsFragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.synergysport.synergysportandroid.R

class TrainingsFragment : Fragment(R.layout.fragment_trainings) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView(view)
    }

    private fun initRecyclerView(view: View) {
        val trainingsRv = view.findViewById<RecyclerView>(R.id.trainings_rv)
        with(trainingsRv) {
            adapter = TrainingsListAdapter()
        }
    }
}