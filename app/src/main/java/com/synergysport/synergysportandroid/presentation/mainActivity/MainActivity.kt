package com.synergysport.synergysportandroid.presentation.mainActivity

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.synergysport.synergysportandroid.R
import com.synergysport.synergysportandroid.SynergySportApp
import com.synergysport.synergysportandroid.presentation.MainFragment
import com.synergysport.synergysportandroid.presentation.common.Navigator
import com.synergysport.synergysportandroid.presentation.common.ToolbarVisibilityListener
import com.synergysport.synergysportandroid.presentation.fragments.achievementsFragment.AchievementsFragment
import com.synergysport.synergysportandroid.presentation.fragments.firstStartFragment.FirstStartFragment
import com.synergysport.synergysportandroid.presentation.fragments.profileFragment.ProfileFragment
import com.synergysport.synergysportandroid.presentation.fragments.trackerFragment.TrackerFragment
import com.synergysport.synergysportandroid.presentation.fragments.trainingsFragment.TrainingsFragment
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

        findViewById<NavigationView>(R.id.nav_view).setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_profile -> {
                    Navigator.navigateReplace(ProfileFragment(), supportFragmentManager)
                }

                R.id.nav_start_training -> {
                    Navigator.navigateReplace(TrackerFragment(), supportFragmentManager)
                }

                R.id.nav_my_trainings -> {
                    Navigator.navigateReplace(TrainingsFragment(), supportFragmentManager)
                }

                R.id.nav_my_achievements -> {
                    Navigator.navigateReplace(AchievementsFragment(), supportFragmentManager)
                }
            }
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }
    }

    private fun bindViewModel() {
        mainActivityViewModel.isAuthorizedLiveData.observe(this) {
            if (it) Navigator.navigateReplace(
                MainFragment(),
                supportFragmentManager
            ) else Navigator.navigateReplace(
                FirstStartFragment(),
                supportFragmentManager
            )
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true
        } else super.onOptionsItemSelected(item)
    }

    override fun showToolbar() {
        supportActionBar?.show()
    }

    override fun hideToolbar() {
        supportActionBar?.hide()
    }
}