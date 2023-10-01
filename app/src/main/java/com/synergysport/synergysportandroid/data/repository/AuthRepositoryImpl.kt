package com.synergysport.synergysportandroid.data.repository

import com.synergysport.synergysportandroid.data.network.api.AuthApi
import com.synergysport.synergysportandroid.data.dto.TokenData
import com.synergysport.synergysportandroid.data.dto.UserData
import com.synergysport.synergysportandroid.domain.repository.AuthRepository
import com.synergysport.synergysportandroid.domain.handler.TokenDataHandler
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Named

class AuthRepositoryImpl @Inject constructor(
    @Named("NoAuthInterceptor")
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