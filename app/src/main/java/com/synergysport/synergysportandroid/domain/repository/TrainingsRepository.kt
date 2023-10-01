package com.synergysport.synergysportandroid.domain.repository

import com.synergysport.synergysportandroid.domain.entity.Training
import io.reactivex.Single

interface TrainingsRepository {
    fun getTrainings(): Single<List<Training>>
}