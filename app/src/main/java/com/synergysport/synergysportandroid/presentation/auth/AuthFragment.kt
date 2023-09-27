package com.synergysport.synergysportandroid.presentation.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.synergysport.synergysportandroid.R
import com.synergysport.synergysportandroid.SynergySportApp
import com.synergysport.synergysportandroid.databinding.FragmentAuthBinding
import com.synergysport.synergysportandroid.presentation.MainFragment
import javax.inject.Inject

class AuthFragment : Fragment() {

    private lateinit var binding: FragmentAuthBinding

    @Inject
    lateinit var viewModel: AuthFragmentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireActivity().application as SynergySportApp).appComponent.inject(this)
    }

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
        initViews()
        bindViewModel()
    }

    private fun initViews() {
        binding.submitButton.setOnClickListener {
            val login = binding.loginTv.text.toString()
            val password = binding.passwordTv.text.toString()
            viewModel.onClickAuth(login, password)
        }
    }

    private fun bindViewModel() {
        with(viewModel) {
            onClickAuthLiveData.observe(viewLifecycleOwner) {
                setMainScreen()
            }
            errorAuthLiveData.observe(viewLifecycleOwner) {
                showErrorAuthMessage()
            }
        }
    }

    private fun showErrorAuthMessage() {
        Toast.makeText(requireContext(), getString(R.string.error_auth_message), Toast.LENGTH_LONG)
            .show()
    }

    private fun setMainScreen() {
        val fragment = MainFragment()
        parentFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}