package com.synergysport.synergysportandroid.domain.repository

import com.synergysport.synergysportandroid.domain.entity.MetricData
import io.reactivex.Completable

interface MetricsRepository {
    fun sendMetrics(metricData: MetricData): Completable
}