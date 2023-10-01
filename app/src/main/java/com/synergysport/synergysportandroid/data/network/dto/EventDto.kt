package com.synergysport.synergysportandroid.data.network.dto

import com.google.gson.annotations.SerializedName
import com.synergysport.synergysportandroid.domain.entity.EventItem

data class EventDto(
    @SerializedName("status_txt") val status: String,
    @SerializedName("title") val title: String,
    @SerializedName("description") val description: String,
    @SerializedName("cost_units") val units: Int,
    @SerializedName("start_date") val date: String,
) {
    fun toItem() = EventItem(status, title, description, units, date)
}