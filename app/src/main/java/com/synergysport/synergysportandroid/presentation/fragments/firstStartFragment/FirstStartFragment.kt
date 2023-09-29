package com.synergysport.synergysportandroid.presentation.fragments.firstStartFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.synergysport.synergysportandroid.R
import com.synergysport.synergysportandroid.presentation.auth.AuthFragment
import com.synergysport.synergysportandroid.presentation.common.ToolbarVisibilityListener

class FirstStartFragment : Fragment(R.layout.fragment_first_start) {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (requireActivity() as? ToolbarVisibilityListener)?.hideToolbar()
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.login_button).setOnClickListener {
            navigateToAuthScreen()
        }
    }

    private fun navigateToAuthScreen() {
        val fragment = AuthFragment()
        parentFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}