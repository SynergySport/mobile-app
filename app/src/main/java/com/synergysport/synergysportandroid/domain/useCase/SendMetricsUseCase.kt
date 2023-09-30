package com.synergysport.synergysportandroid.domain.useCase

import com.synergysport.synergysportandroid.domain.entity.MetricData
import com.synergysport.synergysportandroid.domain.repository.MetricsRepository
import io.reactivex.Completable
import javax.inject.Inject

class SendMetricsUseCase @Inject constructor(
    private val metricsRepository: MetricsRepository
){
    fun sendMetrics(metricData: MetricData): Completable {
        return metricsRepository.sendMetrics(metricData)
    }
}