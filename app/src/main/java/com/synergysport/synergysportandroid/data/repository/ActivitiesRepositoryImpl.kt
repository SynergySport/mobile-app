package com.synergysport.synergysportandroid.data.repository

import com.synergysport.synergysportandroid.data.database.entities.ActivityEntityDao
import com.synergysport.synergysportandroid.data.network.api.ActivitiesApi
import com.synergysport.synergysportandroid.domain.entity.ActivityItem
import com.synergysport.synergysportandroid.domain.repository.ActivitiesRepository
import io.reactivex.Single
import javax.inject.Inject

class ActivitiesRepositoryImpl @Inject constructor(
    private val activityEntityDao: ActivityEntityDao,
    private val activitiesApi: ActivitiesApi
) : ActivitiesRepository {
    override fun getAllActivities(): Single<List<ActivityItem>> {
        return activitiesApi.getAllActivities().map {
            it.map {
                it.toActivityItem()
            }
        }
    }

    override fun getFavoriteActivities(): Single<List<ActivityItem>> {
        return activitiesApi.getFavoriteActivities().map { it.map { it.toActivityItem() } }
    }
}