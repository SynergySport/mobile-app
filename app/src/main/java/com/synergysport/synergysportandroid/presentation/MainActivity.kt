package com.synergysport.synergysportandroid.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.synergysport.synergysportandroid.R
import com.synergysport.synergysportandroid.presentation.auth.AuthFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setAuthScreen()
    }

    private fun setAuthScreen() {
        val fragment = AuthFragment()
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container, fragment)
            .commit()
    }
}