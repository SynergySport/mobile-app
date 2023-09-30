package com.synergysport.synergysportandroid.domain.useCase

import com.synergysport.synergysportandroid.domain.repository.ActivitiesRepository
import javax.inject.Inject

class GetActivitiesUseCase @Inject constructor(
    private val activitiesRepository: ActivitiesRepository
) {
    fun getAllActivities() =
        activitiesRepository.getAllActivities()

    fun getFavoriteActivities() = activitiesRepository.getFavoriteActivities()
}