package com.synergysport.synergysportandroid.data.network.dto

import com.google.gson.annotations.SerializedName

data class TrainingDto(
    @SerializedName("id") val id: Int,
    @SerializedName("start_datetime") val date: String,
    @SerializedName("count_unit") val countUnit: Double,
    @SerializedName("activity") val activityId: Int,
)
