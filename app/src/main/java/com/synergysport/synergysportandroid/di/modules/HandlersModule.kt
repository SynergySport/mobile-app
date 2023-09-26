package com.synergysport.synergysportandroid.di.modules

import com.synergysport.synergysportandroid.data.repository.TokenDataHandler
import com.synergysport.synergysportandroid.data.repository.TokenDataHandlerImpl
import dagger.Binds
import dagger.Module

@Module
abstract class HandlersModule {
    @Binds
    abstract fun provideTokenDataHandler(tokenDataHandler: TokenDataHandlerImpl): TokenDataHandler
}