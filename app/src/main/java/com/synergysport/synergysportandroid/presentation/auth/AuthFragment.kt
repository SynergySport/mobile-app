package com.synergysport.synergysportandroid.presentation.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.synergysport.synergysportandroid.R
import com.synergysport.synergysportandroid.databinding.FragmentAuthBinding
import com.synergysport.synergysportandroid.presentation.MainFragment

class AuthFragment : Fragment() {

    private lateinit var binding: FragmentAuthBinding
    private lateinit var viewModel: AuthFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAuthBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[AuthFragmentViewModel::class.java]
        initViews()
        bindViewModel()
    }

    private fun initViews() {
        binding.submitButton.setOnClickListener {
            viewModel.onClickAuth()
        }
    }

    private fun bindViewModel() {
        viewModel.onClickAuthLiveData.observe(viewLifecycleOwner) {
            setMainScreen()
        }
    }

    private fun setMainScreen() {
        val fragment = MainFragment()
        parentFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}