package com.synergysport.synergysportandroid.domain.entity

import androidx.annotation.DrawableRes

data class ActivityItem(
    val id: Int,
    val name: String,
    val unitLabel: String,
    @DrawableRes val icon: Int,
    val isSelected: Boolean = false
)
