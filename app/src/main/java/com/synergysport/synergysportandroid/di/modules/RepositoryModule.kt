package com.synergysport.synergysportandroid.di.modules

import com.synergysport.synergysportandroid.data.repository.AuthRepositoryImpl
import com.synergysport.synergysportandroid.domain.AuthRepository
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {
    @Binds
    abstract fun provideAuthRepository(repository: AuthRepositoryImpl): AuthRepository
}