package com.synergysport.synergysportandroid.presentation.mainActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.synergysport.synergysportandroid.R
import com.synergysport.synergysportandroid.SynergySportApp
import com.synergysport.synergysportandroid.presentation.auth.AuthFragment
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var mainActivityViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as SynergySportApp).appComponent.inject(this)
        setContentView(R.layout.activity_main)
        setAuthScreen()
        mainActivityViewModel.init()
    }

    private fun setAuthScreen() {
        val fragment = AuthFragment()
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container, fragment)
            .commit()
    }
}