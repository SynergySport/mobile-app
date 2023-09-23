package com.synergysport.synergysportandroid.domain

import com.synergysport.synergysportandroid.data.dto.UserData

class AuthUseCase(
    private val authRepository: AuthRepository
) {
    fun auth(userData: UserData) =
        authRepository.auth(userData)

}