package com.synergysport.synergysportandroid.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.synergysport.synergysportandroid.data.database.AppDatabase.Companion.DATABASE_VERSION
import com.synergysport.synergysportandroid.data.database.entities.ActivityEntity
import com.synergysport.synergysportandroid.data.database.entities.ActivityEntityDao

@Database(
    entities = [ActivityEntity::class],
    version = DATABASE_VERSION,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        const val DATABASE_NAME: String = "SynergySportDb"
        const val DATABASE_VERSION = 1
    }

    abstract fun activityEntityDao(): ActivityEntityDao
}