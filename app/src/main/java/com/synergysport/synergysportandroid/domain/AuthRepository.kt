package com.synergysport.synergysportandroid.domain

import com.synergysport.synergysportandroid.data.dto.TokenData
import com.synergysport.synergysportandroid.data.dto.UserData
import io.reactivex.Single

interface AuthRepository {
    fun auth(userData: UserData): Single<TokenData>
}