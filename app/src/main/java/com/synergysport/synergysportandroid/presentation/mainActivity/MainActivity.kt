package com.synergysport.synergysportandroid.presentation.mainActivity

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.synergysport.synergysportandroid.R
import com.synergysport.synergysportandroid.SynergySportApp
import com.synergysport.synergysportandroid.presentation.MainFragment
import com.synergysport.synergysportandroid.presentation.common.ToolbarVisibilityListener
import com.synergysport.synergysportandroid.presentation.firstStartFragment.FirstStartFragment
import javax.inject.Inject

class MainActivity : AppCompatActivity(), ToolbarVisibilityListener {

    @Inject
    lateinit var mainActivityViewModel: MainActivityViewModel

    lateinit var drawerLayout: DrawerLayout
    lateinit var actionBarDrawerToggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as SynergySportApp).appComponent.inject(this)
        setContentView(R.layout.activity_main)
        initToolbar()
        bindViewModel()
        mainActivityViewModel.checkUserAuthorized()
    }

    private fun initToolbar() {
        drawerLayout = findViewById(R.id.my_drawer_layout)
        actionBarDrawerToggle =
            ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close)

        // pass the Open and Close toggle for the drawer layout listener
        // to toggle the button
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        // to make the Navigation drawer icon always appear on the action bar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
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

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            true
        } else super.onOptionsItemSelected(item)
    }

    override fun showToolbar() {
        supportActionBar?.show()
    }

    override fun hideToolbar() {
        supportActionBar?.hide()
    }
}