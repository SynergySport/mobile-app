package com.synergysport.synergysportandroid.di.modules

import android.content.Context
import com.synergysport.synergysportandroid.SynergySportApp
import dagger.Module
import dagger.Provides

@Module
class AppModule(private val app: SynergySportApp) {

    @Provides
    fun provideAppContext(): Context {
        return app
    }

}