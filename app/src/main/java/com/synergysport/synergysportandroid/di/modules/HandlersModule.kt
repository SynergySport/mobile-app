package com.synergysport.synergysportandroid.di.modules

import com.synergysport.synergysportandroid.data.repository.SelectedActivityDataHandlerImpl
import com.synergysport.synergysportandroid.domain.handler.TokenDataHandler
import com.synergysport.synergysportandroid.data.repository.TokenDataHandlerImpl
import com.synergysport.synergysportandroid.domain.handler.SelectedActivityDataHandler
import dagger.Binds
import dagger.Module

@Module
abstract class HandlersModule {
    @Binds
    abstract fun provideTokenDataHandler(tokenDataHandler: TokenDataHandlerImpl): TokenDataHandler

    @Binds
    abstract fun provideActivityDataHandler(selectedActivityDataHandler: SelectedActivityDataHandlerImpl): SelectedActivityDataHandler
}