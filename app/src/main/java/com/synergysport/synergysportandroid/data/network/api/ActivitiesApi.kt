package com.synergysport.synergysportandroid.data.network.api

import com.synergysport.synergysportandroid.data.network.dto.ActivityDto
import io.reactivex.Single
import retrofit2.http.GET

interface ActivitiesApi {
    @GET("api/activity/list/")
    fun getAllActivities(): Single<List<ActivityDto>>

    @GET("api/activity/list/?status=favorite")
    fun getFavoriteActivities(): Single<List<ActivityDto>>
}