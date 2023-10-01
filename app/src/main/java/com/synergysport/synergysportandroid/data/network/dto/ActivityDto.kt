package com.synergysport.synergysportandroid.data.network.dto

import com.synergysport.synergysportandroid.R
import com.synergysport.synergysportandroid.data.database.entities.ActivityEntity
import com.synergysport.synergysportandroid.domain.entity.ActivityItem

data class ActivityDto(
    val id: Int,
    val title: String,
    val unit: String,
    val cost_unit: Double,
    val unit_label: String
) {
    fun toActivityItem() = ActivityItem(
        id = id,
        name = title,
        unit = unit,
        unitLabel = unit_label,
        costUnit = cost_unit,
        icon = R.drawable.ic_run,
    )

    fun toActivityEntity() = ActivityEntity(
        id = id,
        name = title,
        unit = unit,
        costUnit = cost_unit,
        unitLabel = unit_label
    )
}