package com.synergysport.synergysportandroid.domain

import com.synergysport.synergysportandroid.data.dto.UserData
import javax.inject.Inject

class AuthUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    fun auth(userData: UserData) =
        authRepository.auth(userData)

}