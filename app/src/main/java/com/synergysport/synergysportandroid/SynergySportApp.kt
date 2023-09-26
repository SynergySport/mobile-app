package com.synergysport.synergysportandroid

import android.app.Application
import com.synergysport.synergysportandroid.di.DaggerAppComponent
import com.synergysport.synergysportandroid.di.modules.AppModule

class SynergySportApp : Application() {
    val appComponent = DaggerAppComponent.builder()
        .appModule(AppModule(this))
        .build()
}