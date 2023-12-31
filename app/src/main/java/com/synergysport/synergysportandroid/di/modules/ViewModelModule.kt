package com.synergysport.synergysportandroid.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.synergysport.synergysportandroid.di.AppViewModelFactory
import com.synergysport.synergysportandroid.di.ViewModelKey
import com.synergysport.synergysportandroid.presentation.auth.AuthFragmentViewModel
import com.synergysport.synergysportandroid.presentation.fragments.eventsFragment.EventsFragmentViewModel
import com.synergysport.synergysportandroid.presentation.fragments.profileFragment.ProfileFragmentViewModel
import com.synergysport.synergysportandroid.presentation.fragments.selectActivityFragment.adapter.SelectActivityFragmentViewModel
import com.synergysport.synergysportandroid.presentation.fragments.trackerFragment.TrackerFragmentViewModel
import com.synergysport.synergysportandroid.presentation.fragments.trainingsFragment.TrainingsFragmentViewModel
import com.synergysport.synergysportandroid.presentation.mainActivity.MainActivityViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: AppViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(AuthFragmentViewModel::class)
    internal abstract fun bindAuthFragmentViewModel(viewModel: AuthFragmentViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    internal abstract fun bindMainActivityViewModel(viewModel: MainActivityViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SelectActivityFragmentViewModel::class)
    internal abstract fun bindSelectActivityViewModel(viewModel: SelectActivityFragmentViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(TrackerFragmentViewModel::class)
    internal abstract fun bindTrackerFragmentViewModel(viewModel: TrackerFragmentViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ProfileFragmentViewModel::class)
    internal abstract fun bindProfileFragmentViewModel(viewModel: ProfileFragmentViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(TrainingsFragmentViewModel::class)
    internal abstract fun bindTrainingsFragmentViewModel(viewModel: TrainingsFragmentViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(EventsFragmentViewModel::class)
    internal abstract fun bindEventsFragmentViewModel(viewModel: EventsFragmentViewModel): ViewModel

}