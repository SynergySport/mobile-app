package com.synergysport.synergysportandroid.presentation.mainActivity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.synergysport.synergysportandroid.R
import com.synergysport.synergysportandroid.SynergySportApp
import com.synergysport.synergysportandroid.presentation.MainFragment
import com.synergysport.synergysportandroid.presentation.firstStartFragment.FirstStartFragment
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var mainActivityViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as SynergySportApp).appComponent.inject(this)
        setContentView(R.layout.activity_main)
//        bindViewModel()
//        mainActivityViewModel.checkUserAuthorized()
        //TODO: временно не авторизуемся
        setMainScreen()
    }

    private fun bindViewModel() {
        mainActivityViewModel.isAuthorizedLiveData.observe(this) {
            if (it) setMainScreen() else setFirstStartScreen()
        }
    }

    private fun setMainScreen() {
        val fragment = MainFragment()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

    private fun setFirstStartScreen() {
        val fragment = FirstStartFragment()
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container, fragment)
            .commit()
    }
}