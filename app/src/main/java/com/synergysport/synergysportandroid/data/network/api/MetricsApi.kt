package com.synergysport.synergysportandroid.data.network.api

import com.synergysport.synergysportandroid.data.dto.MetricDataDto
import io.reactivex.Completable
import retrofit2.http.Body
import retrofit2.http.POST

interface MetricsApi {
    @POST("api/tracker/push/")
    fun sendMetrics(@Body metricDataDto: MetricDataDto): Completable
}