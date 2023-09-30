package com.synergysport.synergysportandroid.presentation.fragments.selectActivityTypeFragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.synergysport.synergysportandroid.R
import com.synergysport.synergysportandroid.domain.entity.Activity

class SelectActivityTypeFragment : Fragment(R.layout.fragment_select_activity_type) {
    private lateinit var activityListAdapter: ActivityListAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView(view)
    }

    private fun initRecyclerView(view: View) {
        val activitiesRv = view.findViewById<RecyclerView>(R.id.activities_rv)
        activityListAdapter = ActivityListAdapter()
        with(activitiesRv) {
            adapter = activityListAdapter
            activityListAdapter.submitList(
                listOf(
                    Activity(1, "Бег", R.drawable.ic_run),
                    Activity(2, "Ходьба", R.drawable.ic_run),
                    Activity(3, "Зал", R.drawable.ic_run),
                )
            )
        }
    }
}