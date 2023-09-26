package com.synergysport.synergysportandroid.data.repository

import com.synergysport.synergysportandroid.data.api.AuthApi
import com.synergysport.synergysportandroid.data.dto.TokenData
import com.synergysport.synergysportandroid.data.dto.UserData
import com.synergysport.synergysportandroid.domain.AuthRepository
import com.synergysport.synergysportandroid.domain.TokenDataHandler
import io.reactivex.Single
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authApi: AuthApi,
    private val tokenDataHandler: TokenDataHandler
) : AuthRepository {
    override fun auth(userData: UserData) = authApi.auth(userData).flatMap {
        saveTokenData(it)
        Single.just(it)
    }

    private fun saveTokenData(tokenData: TokenData) {
        tokenDataHandler.saveToken(tokenData)
    }
}