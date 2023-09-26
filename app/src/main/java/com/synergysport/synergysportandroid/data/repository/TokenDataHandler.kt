package com.synergysport.synergysportandroid.data.repository

import com.synergysport.synergysportandroid.data.dto.TokenData

interface TokenDataHandler {
    fun saveToken(tokenData: TokenData)
    fun getToken(): TokenData
}