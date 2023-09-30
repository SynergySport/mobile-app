package com.synergysport.synergysportandroid.data.network.dto

import com.synergysport.synergysportandroid.R
import com.synergysport.synergysportandroid.data.database.entities.ActivityEntity
import com.synergysport.synergysportandroid.domain.entity.ActivityItem

data class ActivityDto(
    val id: Int,
    val title: String,
    val unit_label: String
) {
    fun toActivityItem() = ActivityItem(
        id = id,
        name = title,
        unitLabel = unit_label,
        icon = R.drawable.ic_run,
    )

    fun toActivityEntity() = ActivityEntity(
        id = id,
        name = title,
        unitLabel = unit_label
    )
}