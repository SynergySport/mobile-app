package com.synergysport.synergysportandroid.presentation.fragments.selectActivityFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.synergysport.synergysportandroid.R
import com.synergysport.synergysportandroid.SynergySportApp
import com.synergysport.synergysportandroid.databinding.FragmentSelectActivityBinding
import com.synergysport.synergysportandroid.presentation.common.Navigator
import com.synergysport.synergysportandroid.presentation.fragments.selectActivityFragment.adapter.ActivityListAdapter
import com.synergysport.synergysportandroid.presentation.fragments.selectActivityFragment.adapter.SelectActivityFragmentViewModel
import javax.inject.Inject

class SelectActivityFragment : Fragment(R.layout.fragment_select_activity) {
    private lateinit var activityListAdapter: ActivityListAdapter

    private lateinit var binding: FragmentSelectActivityBinding

    @Inject
    lateinit var viewModel: SelectActivityFragmentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireActivity().application as SynergySportApp).appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSelectActivityBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        bindViewModel()
        viewModel.init()
    }

    private fun initViews() {
        initRecyclerView()
        initApplyButton()
        initTabs()
        initBackButton()
    }

    private fun initApplyButton() {
        binding.applyButton.setOnClickListener {
            viewModel.saveSelectedActivity()
        }
    }

    private fun initTabs() {
        binding.favoriteTabButton.setOnClickListener {
            viewModel.onClickFavorite()
        }
        binding.allTabButton.setOnClickListener {
            viewModel.onClickAll()
        }
    }

    private fun initBackButton() {
        binding.backButton.setOnClickListener {
            Navigator.closeFragment(parentFragmentManager)
        }
    }

    private fun bindViewModel() {
        with(viewModel) {
            allActivitiesLiveData.observe(viewLifecycleOwner) {
                activityListAdapter.submitList(
                    it
                )
            }
            favoriteActivitiesLiveData.observe(viewLifecycleOwner) {
                activityListAdapter.submitList(
                    it
                )
            }
            shouldCloseScreenLiveData.observe(viewLifecycleOwner) {
                Navigator.closeFragment(parentFragmentManager)
            }
            onClickFavoriteLiveData.observe(viewLifecycleOwner) {
                with(binding) {
                    favoriteTabButton.setBackgroundResource(R.drawable.bg_round_primary)
                    favoriteTabButton.setTextColor(
                        resources.getColor(
                            R.color.white,
                            requireContext().theme
                        )
                    )
                    allTabButton.setBackgroundResource(R.drawable.bg_round_white)
                    allTabButton.setTextColor(
                        resources.getColor(
                            R.color.black,
                            requireContext().theme
                        )
                    )
                }
            }
            onClickAllLiveData.observe(viewLifecycleOwner) {
                with(binding) {
                    allTabButton.setBackgroundResource(R.drawable.bg_round_primary)
                    allTabButton.setTextColor(
                        resources.getColor(
                            R.color.white,
                            requireContext().theme
                        )
                    )
                    favoriteTabButton.setBackgroundResource(R.drawable.bg_round_white)
                    favoriteTabButton.setTextColor(
                        resources.getColor(
                            R.color.black,
                            requireContext().theme
                        )
                    )
                }
            }
        }
    }

    private fun initRecyclerView() {
        activityListAdapter = ActivityListAdapter()
        activityListAdapter.onItemClicked = {
            viewModel.onClickActivityItem(it)
        }
        with(binding.activitiesRv) {
            adapter = activityListAdapter
        }
    }
}