package com.synergysport.synergysportandroid

import android.app.Application
import com.synergysport.synergysportandroid.di.DaggerAppComponent

class SynergySportApp : Application() {
    val appComponent = DaggerAppComponent.builder()
        .build()
}