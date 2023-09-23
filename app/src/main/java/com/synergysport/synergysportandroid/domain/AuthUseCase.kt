package com.synergysport.synergysportandroid.domain

class AuthUseCase(
    private val authRepository: AuthRepository
) {
    fun auth() {
        authRepository.auth()
    }
}