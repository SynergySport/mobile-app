package com.synergysport.synergysportandroid.di.modules

import com.synergysport.synergysportandroid.data.repository.SelectedActivityDataHandlerImpl
import com.synergysport.synergysportandroid.domain.handler.TokenDataHandler
import com.synergysport.synergysportandroid.data.repository.TokenDataHandlerImpl
import com.synergysport.synergysportandroid.domain.handler.SelectedActivityDataHandler
import com.synergysport.synergysportandroid.presentation.fragments.trackerFragment.StepTracker
import com.synergysport.synergysportandroid.presentation.fragments.trackerFragment.StepTrackerImpl
import dagger.Binds
import dagger.Module

@Module
abstract class HandlersModule {
    @Binds
    abstract fun provideTokenDataHandler(tokenDataHandler: TokenDataHandlerImpl): TokenDataHandler

    @Binds
    abstract fun provideActivityDataHandler(selectedActivityDataHandler: SelectedActivityDataHandlerImpl): SelectedActivityDataHandler

    @Binds
    abstract fun provideStepTracker(stepTracker: StepTrackerImpl): StepTracker
}