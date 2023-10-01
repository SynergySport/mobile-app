package com.synergysport.synergysportandroid.domain.entity

import androidx.annotation.DrawableRes

data class ActivityItem(
    val id: Int,
    val name: String,
    val unit: String,
    val unitLabel: String,
    val costUnit: Double,
    @DrawableRes val icon: Int,
    val isSelected: Boolean = false
)
