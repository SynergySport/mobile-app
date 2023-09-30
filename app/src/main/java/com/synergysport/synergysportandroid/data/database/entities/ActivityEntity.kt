package com.synergysport.synergysportandroid.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ActivityEntity(
    @PrimaryKey val id: Int
)
