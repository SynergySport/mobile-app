package com.synergysport.synergysportandroid.di.modules

import com.synergysport.synergysportandroid.data.repository.ActivitiesRepositoryImpl
import com.synergysport.synergysportandroid.data.repository.AuthRepositoryImpl
import com.synergysport.synergysportandroid.data.repository.EventsRepositoryImpl
import com.synergysport.synergysportandroid.data.repository.MetricRepositoryImpl
import com.synergysport.synergysportandroid.data.repository.ProfileRepositoryImpl
import com.synergysport.synergysportandroid.data.repository.TrainingsRepositoryImpl
import com.synergysport.synergysportandroid.domain.repository.ActivitiesRepository
import com.synergysport.synergysportandroid.domain.repository.AuthRepository
import com.synergysport.synergysportandroid.domain.repository.EventsRepository
import com.synergysport.synergysportandroid.domain.repository.MetricsRepository
import com.synergysport.synergysportandroid.domain.repository.ProfileRepository
import com.synergysport.synergysportandroid.domain.repository.TrainingsRepository
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {
    @Binds
    abstract fun provideAuthRepository(repository: AuthRepositoryImpl): AuthRepository

    @Binds
    abstract fun provideActivitiesRepository(repository: ActivitiesRepositoryImpl): ActivitiesRepository

    @Binds
    abstract fun provideMetricsRepository(repository: MetricRepositoryImpl): MetricsRepository

    @Binds
    abstract fun provideProfileRepository(profileRepository: ProfileRepositoryImpl): ProfileRepository

    @Binds
    abstract fun provideTrainingsRepository(trainingsRepository: TrainingsRepositoryImpl): TrainingsRepository

    @Binds
    abstract fun provideEventsRepository(eventsRepository: EventsRepositoryImpl): EventsRepository
}