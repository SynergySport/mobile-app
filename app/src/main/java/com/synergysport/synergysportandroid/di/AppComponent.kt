package com.synergysport.synergysportandroid.di

import com.synergysport.synergysportandroid.di.modules.AppModule
import com.synergysport.synergysportandroid.di.modules.DatabaseModule
import com.synergysport.synergysportandroid.di.modules.NetworkModule
import com.synergysport.synergysportandroid.di.modules.HandlersModule
import com.synergysport.synergysportandroid.di.modules.PermissionsControllerModule
import com.synergysport.synergysportandroid.di.modules.RepositoryModule
import com.synergysport.synergysportandroid.di.modules.ViewModelModule
import com.synergysport.synergysportandroid.presentation.auth.AuthFragment
import com.synergysport.synergysportandroid.presentation.fragments.profileFragment.ProfileFragment
import com.synergysport.synergysportandroid.presentation.fragments.selectActivityFragment.SelectActivityFragment
import com.synergysport.synergysportandroid.presentation.fragments.trackerFragment.TrackerFragment
import com.synergysport.synergysportandroid.presentation.fragments.trainingsFragment.TrainingsFragment
import com.synergysport.synergysportandroid.presentation.mainActivity.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        RepositoryModule::class,
        NetworkModule::class,
        ViewModelModule::class,
        HandlersModule::class,
        AppModule::class,
        PermissionsControllerModule::class,
        DatabaseModule::class
    ]
)
interface AppComponent {

    fun inject(mainActivity: MainActivity)

    fun inject(authFragment: AuthFragment)

    fun inject(selectActivityFragment: SelectActivityFragment)

    fun inject(trackerFragment: TrackerFragment)

    fun inject(profileFragment: ProfileFragment)

    fun inject(trainingsFragment: TrainingsFragment)

}