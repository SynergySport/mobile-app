package com.synergysport.synergysportandroid.domain.useCase

import com.synergysport.synergysportandroid.domain.repository.ProfileRepository
import javax.inject.Inject

class GetProfileInfoUseCase @Inject constructor(
    private val profileRepository: ProfileRepository
) {
    fun getProfileInfo() = profileRepository.getProfileInfo()
}