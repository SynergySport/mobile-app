package com.synergysport.synergysportandroid.data.network.api

import com.synergysport.synergysportandroid.data.dto.TokenData
import com.synergysport.synergysportandroid.data.dto.UserData
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {
    @POST("api-token-auth/")
    fun auth(@Body userData: UserData): Single<TokenData>
}