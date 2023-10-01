package com.synergysport.synergysportandroid.presentation.fragments.eventsFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.synergysport.synergysportandroid.R
import com.synergysport.synergysportandroid.SynergySportApp
import com.synergysport.synergysportandroid.databinding.FragmentEventsBinding
import com.synergysport.synergysportandroid.databinding.FragmentProfileBinding
import com.synergysport.synergysportandroid.presentation.fragments.profileFragment.ProfileFragmentViewModel
import javax.inject.Inject

class EventsFragment : Fragment() {

    private lateinit var binding: FragmentEventsBinding

    @Inject
    lateinit var viewModel: EventsFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEventsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireActivity().application as SynergySportApp).appComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindViewModel()
        viewModel.init()
    }

    private fun bindViewModel() {

    }

}