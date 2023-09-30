package com.synergysport.synergysportandroid.domain.entity

import androidx.annotation.DrawableRes

data class ActivityItem(
    val id: Int,
    val name: String,
    @DrawableRes val icon: Int
)