package com.synergysport.synergysportandroid.data.network.dto

import com.synergysport.synergysportandroid.R
import com.synergysport.synergysportandroid.domain.entity.ActivityItem

data class ActivityDto(
    val id: Int,
    val title: String
) {
    fun toActivityItem() = ActivityItem(
        id = id,
        name = title,
        R.drawable.ic_run
    )
}