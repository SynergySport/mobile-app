package com.synergysport.synergysportandroid.domain.handler

import com.synergysport.synergysportandroid.data.network.dto.TokenData

interface TokenDataHandler {
    fun saveToken(tokenData: TokenData)
    fun getToken(): TokenData
    fun isTokenEmpty(): Boolean
    fun isTokenNotEmpty(): Boolean
}