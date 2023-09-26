package com.synergysport.synergysportandroid.domain

import com.synergysport.synergysportandroid.data.dto.TokenData

interface TokenDataHandler {
    fun saveToken(tokenData: TokenData)
    fun getToken(): TokenData
}