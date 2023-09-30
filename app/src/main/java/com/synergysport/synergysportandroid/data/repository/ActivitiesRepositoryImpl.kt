package com.synergysport.synergysportandroid.data.repository

import com.synergysport.synergysportandroid.R
import com.synergysport.synergysportandroid.data.api.ActivitiesApi
import com.synergysport.synergysportandroid.data.database.entities.ActivityEntityDao
import com.synergysport.synergysportandroid.domain.entity.ActivityItem
import com.synergysport.synergysportandroid.domain.repository.ActivitiesRepository
import io.reactivex.Single
import javax.inject.Inject

class ActivitiesRepositoryImpl @Inject constructor(
    private val activityEntityDao: ActivityEntityDao,
    private val activitiesApi: ActivitiesApi
) : ActivitiesRepository {
    override fun getAllActivities(): Single<List<ActivityItem>> {
        return Single.just(
            listOf(
                ActivityItem(1, "Бег", R.drawable.ic_run),
                ActivityItem(2, "Ходьба", R.drawable.ic_run),
                ActivityItem(3, "Зал", R.drawable.ic_run),
            )
        )
    }

    override fun getFavoriteActivities(): Single<List<ActivityItem>> {
        return Single.just(
            listOf(
                ActivityItem(1, "Бег", R.drawable.ic_run),
                ActivityItem(2, "Ходьба", R.drawable.ic_run),
            )
        )
    }
}