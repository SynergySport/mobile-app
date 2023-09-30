package com.synergysport.synergysportandroid.domain.repository

import android.app.Activity
import io.reactivex.Single

interface ActivitiesRepository {
    fun getAllActivities(): Single<List<Activity>>
    fun getFavoriteActivities(): Single<List<Activity>>
}