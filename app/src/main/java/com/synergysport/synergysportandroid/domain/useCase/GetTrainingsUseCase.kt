package com.synergysport.synergysportandroid.domain.useCase

import com.synergysport.synergysportandroid.domain.entity.Training
import com.synergysport.synergysportandroid.domain.repository.TrainingsRepository
import io.reactivex.Single
import javax.inject.Inject

class GetTrainingsUseCase @Inject constructor(
    private val trainingsRepository: TrainingsRepository
) {
    fun getTrainings(): Single<List<Training>> {
        return trainingsRepository.getTrainings()
    }
}