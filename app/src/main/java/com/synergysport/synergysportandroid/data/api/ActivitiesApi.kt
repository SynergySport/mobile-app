package com.synergysport.synergysportandroid.data.api

import android.app.Activity
import io.reactivex.Single
import retrofit2.http.GET

interface ActivitiesApi {
    @GET("api/activity/list/")
    fun getAllActivities(): Single<Activity>

    @GET("api/activity/list/?status=favorite")
    fun getFavoriteActivities(): Single<Activity>
}