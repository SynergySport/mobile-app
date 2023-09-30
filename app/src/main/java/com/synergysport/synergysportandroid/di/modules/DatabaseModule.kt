package com.synergysport.synergysportandroid.di.modules

import android.content.Context
import androidx.room.Room
import com.synergysport.synergysportandroid.data.database.AppDatabase
import com.synergysport.synergysportandroid.data.database.entities.ActivityEntityDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Provides
    @Singleton
    fun provideAppDataBase(context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            AppDatabase.DATABASE_NAME
        ).fallbackToDestructiveMigration().build()
    }

    @Provides
    fun getCallEntitiesDao(appDatabase: AppDatabase): ActivityEntityDao = appDatabase.activityEntityDao()

}