package com.synergysport.synergysportandroid.data.repository

import com.synergysport.synergysportandroid.data.api.AuthApi
import com.synergysport.synergysportandroid.data.dto.UserData
import com.synergysport.synergysportandroid.domain.AuthRepository

class AuthRepositoryImpl(private val authApi: AuthApi) : AuthRepository {
    override fun auth(userData: UserData) = authApi.auth(userData)
}