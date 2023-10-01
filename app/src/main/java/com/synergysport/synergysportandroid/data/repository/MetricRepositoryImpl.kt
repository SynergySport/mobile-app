package com.synergysport.synergysportandroid.data.repository

import com.synergysport.synergysportandroid.data.network.dto.MetricDataDto
import com.synergysport.synergysportandroid.data.network.api.MetricsApi
import com.synergysport.synergysportandroid.domain.entity.MetricData
import com.synergysport.synergysportandroid.domain.repository.MetricsRepository
import io.reactivex.Completable
import javax.inject.Inject

class MetricRepositoryImpl @Inject constructor(
    private val metricsApi: MetricsApi
) : MetricsRepository {
    override fun sendMetrics(metricData: MetricData): Completable {
        return metricsApi.sendMetrics(MetricDataDto.fromMetricData(metricData))
    }
}