package com.synergysport.synergysportandroid.presentation.fragments.selectActivityFragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.synergysport.synergysportandroid.R
import com.synergysport.synergysportandroid.SynergySportApp
import com.synergysport.synergysportandroid.presentation.fragments.selectActivityFragment.adapter.ActivityListAdapter
import com.synergysport.synergysportandroid.presentation.fragments.selectActivityFragment.adapter.SelectActivityViewModel
import javax.inject.Inject

class SelectActivityFragment : Fragment(R.layout.fragment_select_activity) {
    private lateinit var activityListAdapter: ActivityListAdapter

    @Inject
    lateinit var viewModel: SelectActivityViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity().application as SynergySportApp).appComponent.inject(this)
        initRecyclerView(view)
        bindViewModel()
        viewModel.init()
    }

    private fun bindViewModel() {
        viewModel.allActivitiesLiveData.observe(viewLifecycleOwner) {
            activityListAdapter.submitList(
                it
            )
        }
    }

    private fun initRecyclerView(view: View) {
        val activitiesRv = view.findViewById<RecyclerView>(R.id.activities_rv)
        activityListAdapter = ActivityListAdapter()
        with(activitiesRv) {
            adapter = activityListAdapter
        }
    }
}