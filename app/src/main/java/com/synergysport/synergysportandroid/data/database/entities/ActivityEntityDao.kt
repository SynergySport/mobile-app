package com.synergysport.synergysportandroid.data.database.entities

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface ActivityEntityDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(activityEntity: ActivityEntity): Completable

    @Query("SELECT * FROM activityentity")
    fun getAll(): Single<List<ActivityEntity>>

    @Query("SELECT * FROM activityentity where id = :id")
    fun getById(id: Int): Single<ActivityEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(activities: List<ActivityEntity>): Completable

}