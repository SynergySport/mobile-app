package com.synergysport.synergysportandroid.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.synergysport.synergysportandroid.R
import com.synergysport.synergysportandroid.presentation.auth.AuthScreenFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setAuthScreen()
    }

    private fun setMainScreen() {
        val fragment = MainScreenFragment()
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container, fragment)
            .commit()
    }

    private fun setAuthScreen() {
        val fragment = AuthScreenFragment()
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container, fragment)
            .commit()
    }
}