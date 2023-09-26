package com.synergysport.synergysportandroid.presentation.firstStartFragment

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import com.synergysport.synergysportandroid.R
import com.synergysport.synergysportandroid.presentation.auth.AuthFragment

class FirstStartFragment : Fragment(R.layout.fragment_first_start) {

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