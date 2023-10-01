package com.synergysport.synergysportandroid.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ActivityEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val unit: String,
    val unitLabel: String,
    val costUnit: Double
)
