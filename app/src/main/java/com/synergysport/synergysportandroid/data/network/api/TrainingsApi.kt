package com.synergysport.synergysportandroid.data.network.api

import com.synergysport.synergysportandroid.data.network.dto.TrainingDto
import io.reactivex.Single
import retrofit2.http.GET

interface TrainingsApi {
    @GET("api/tracker/all/")
    fun getTrainings(): Single<List<TrainingDto>>
}