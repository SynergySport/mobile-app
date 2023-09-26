package com.synergysport.synergysportandroid.di

import com.synergysport.synergysportandroid.di.modules.DataModule
import com.synergysport.synergysportandroid.di.modules.RepositoryModule
import com.synergysport.synergysportandroid.di.modules.ViewModelModule
import com.synergysport.synergysportandroid.presentation.auth.AuthFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        RepositoryModule::class,
        DataModule::class,
        ViewModelModule::class
    ]
)
interface AppComponent {

    fun inject(authFragment: AuthFragment)

}