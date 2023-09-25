package com.synergysport.synergysportandroid.di

import com.synergysport.synergysportandroid.di.modules.DataModule
import com.synergysport.synergysportandroid.di.modules.RepositoryModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        RepositoryModule::class,
        DataModule::class
    ]
)
interface AppComponent {

}