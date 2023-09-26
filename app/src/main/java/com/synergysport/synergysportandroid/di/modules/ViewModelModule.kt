package com.synergysport.synergysportandroid.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.synergysport.synergysportandroid.di.AppViewModelFactory
import com.synergysport.synergysportandroid.di.ViewModelKey
import com.synergysport.synergysportandroid.presentation.auth.AuthFragmentViewModel
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

}