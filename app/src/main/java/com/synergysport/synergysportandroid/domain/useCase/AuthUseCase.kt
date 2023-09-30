package com.synergysport.synergysportandroid.domain.useCase

import com.synergysport.synergysportandroid.data.dto.UserData
import com.synergysport.synergysportandroid.domain.repository.AuthRepository
import javax.inject.Inject

class AuthUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    fun auth(userData: UserData) =
        authRepository.auth(userData)

}