package com.synergysport.synergysportandroid.presentation.fragments.selectActivityFragment

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.synergysport.synergysportandroid.R
import com.synergysport.synergysportandroid.SynergySportApp
import com.synergysport.synergysportandroid.presentation.common.Navigator
import com.synergysport.synergysportandroid.presentation.fragments.selectActivityFragment.adapter.ActivityListAdapter
import com.synergysport.synergysportandroid.presentation.fragments.selectActivityFragment.adapter.SelectActivityFragmentViewModel
import javax.inject.Inject

class SelectActivityFragment : Fragment(R.layout.fragment_select_activity) {
    private lateinit var activityListAdapter: ActivityListAdapter

    @Inject
    lateinit var viewModel: SelectActivityFragmentViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity().application as SynergySportApp).appComponent.inject(this)
        initViews()
        bindViewModel()
        viewModel.init()
    }

    private fun initViews(){
        initRecyclerView()
        initApplyButton()
    }

    private fun initApplyButton(){
        requireView().findViewById<Button>(R.id.apply_button).setOnClickListener {
            viewModel.saveSelectedActivity()
        }
    }

    private fun bindViewModel() {
        with(viewModel) {
            allActivitiesLiveData.observe(viewLifecycleOwner) {
                activityListAdapter.submitList(
                    it
                )
            }
            shouldCloseScreenLiveData.observe(viewLifecycleOwner){
                Navigator.closeFragment(parentFragmentManager)
            }
        }
    }

    private fun initRecyclerView() {
        val activitiesRv = requireView().findViewById<RecyclerView>(R.id.activities_rv)
        activityListAdapter = ActivityListAdapter()
        activityListAdapter.onItemClicked = {
            viewModel.onClickActivityItem(it)
        }
        with(activitiesRv) {
            adapter = activityListAdapter
        }
    }
}