package com.synergysport.synergysportandroid.domain.repository

import com.synergysport.synergysportandroid.domain.entity.ActivityItem
import io.reactivex.Single

interface ActivitiesRepository {
    fun getAllActivities(): Single<List<ActivityItem>>
    fun getFavoriteActivities(): Single<List<ActivityItem>>
}