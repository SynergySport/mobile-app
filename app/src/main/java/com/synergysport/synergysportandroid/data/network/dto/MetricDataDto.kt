package com.synergysport.synergysportandroid.data.network.dto

import com.google.gson.annotations.SerializedName
import com.synergysport.synergysportandroid.domain.entity.MetricData

data class MetricDataDto(
    @SerializedName("activity") val activity: Int,
    @SerializedName("start_datetime") val startDatetime: String,
    @SerializedName("end_datetime") val endDatetime: String,
    @SerializedName("count_unit") val countUnit: Double
){
    companion object {
        fun fromMetricData(metricData: MetricData) = MetricDataDto(
            activity = metricData.activityId,
            startDatetime = metricData.startDate,
            endDatetime = metricData.endDate,
            countUnit = metricData.countUnit
        )
    }
}
