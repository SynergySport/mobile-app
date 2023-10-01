package com.synergysport.synergysportandroid.data.repository

import com.synergysport.synergysportandroid.data.database.entities.ActivityEntityDao
import com.synergysport.synergysportandroid.data.network.api.TrainingsApi
import com.synergysport.synergysportandroid.domain.entity.Training
import com.synergysport.synergysportandroid.domain.repository.TrainingsRepository
import io.reactivex.Single
import javax.inject.Inject

class TrainingsRepositoryImpl @Inject constructor(
    private val trainingsApi: TrainingsApi,
    private val activityEntityDao: ActivityEntityDao
) : TrainingsRepository {
    override fun getTrainings(): Single<List<Training>> {
        return trainingsApi.getTrainings().map {
            it.map {
                Training(
                    id = it.id,
                    type = "None",
                    date = it.date,
                    cores = it.countUnit
                )
            }
        }
    }

}