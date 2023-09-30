package com.synergysport.synergysportandroid.data.repository

import com.synergysport.synergysportandroid.R
import com.synergysport.synergysportandroid.data.database.entities.ActivityEntityDao
import com.synergysport.synergysportandroid.data.network.api.ActivitiesApi
import com.synergysport.synergysportandroid.domain.entity.ActivityItem
import com.synergysport.synergysportandroid.domain.handler.SelectedActivityDataHandler
import com.synergysport.synergysportandroid.domain.repository.ActivitiesRepository
import io.reactivex.Single
import javax.inject.Inject

class ActivitiesRepositoryImpl @Inject constructor(
    private val activityEntityDao: ActivityEntityDao,
    private val activitiesApi: ActivitiesApi,
    private val selectedActivityDataHandler: SelectedActivityDataHandler
) : ActivitiesRepository {
    override fun getAllActivities(): Single<List<ActivityItem>> {
        return activitiesApi.getAllActivities()
            .flatMap { activities ->
                activityEntityDao.insertAll(activities.map { it.toActivityEntity() })
                    .andThen(Single.just(activities.map { it.toActivityItem() }))
            }
    }


    override fun getFavoriteActivities(): Single<List<ActivityItem>> {
        return activitiesApi.getFavoriteActivities().map { it.map { it.toActivityItem() } }
    }

    override fun getSelectedActivity(): Single<ActivityItem> {
        val selectedActivityId = selectedActivityDataHandler.getSelectedActivityItemId()
        return activityEntityDao.getById(selectedActivityId).map {
            ActivityItem(
                id = it.id,
                name = it.name,
                unitLabel = it.unitLabel,
                icon = R.drawable.ic_run
            )
        }
    }
}