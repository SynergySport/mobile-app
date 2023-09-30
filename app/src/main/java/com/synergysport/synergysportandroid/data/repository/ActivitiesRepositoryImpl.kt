package com.synergysport.synergysportandroid.data.repository

import android.app.Activity
import com.synergysport.synergysportandroid.data.api.ActivitiesApi
import com.synergysport.synergysportandroid.data.database.entities.ActivityEntityDao
import com.synergysport.synergysportandroid.domain.repository.ActivitiesRepository
import io.reactivex.Single
import javax.inject.Inject

class ActivitiesRepositoryImpl @Inject constructor(
    private val activityEntityDao: ActivityEntityDao,
    private val activitiesApi: ActivitiesApi
): ActivitiesRepository {
    override fun getAllActivities(): Single<List<Activity>> {
        return Single.just(listOf())
    }

    override fun getFavoriteActivities(): Single<List<Activity>> {
        return Single.just(listOf())
    }
}