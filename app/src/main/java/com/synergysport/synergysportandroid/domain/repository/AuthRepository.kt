package com.synergysport.synergysportandroid.domain.repository

import com.synergysport.synergysportandroid.data.network.dto.TokenData
import com.synergysport.synergysportandroid.data.network.dto.UserData
import io.reactivex.Single

interface AuthRepository {
    fun auth(userData: UserData): Single<TokenData>
}