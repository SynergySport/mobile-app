package com.synergysport.synergysportandroid.data.repository

import android.content.Context
import com.synergysport.synergysportandroid.data.dto.TokenData
import com.synergysport.synergysportandroid.domain.TokenDataHandler
import javax.inject.Inject

class TokenDataHandlerImpl @Inject constructor (private val context: Context): TokenDataHandler {
    override fun saveToken(tokenData: TokenData) {
        context.getSharedPreferences(SHARED_PREFS_FILE_NAME, Context.MODE_PRIVATE).edit()
            .putString(TOKEN_DATA_KEY, tokenData.token).apply()
    }

    override fun getToken() = TokenData(
        context.getSharedPreferences(SHARED_PREFS_FILE_NAME, Context.MODE_PRIVATE)
            .getString(TOKEN_DATA_KEY, "") ?: ""
    )


    companion object {
        const val SHARED_PREFS_FILE_NAME = "synergy_sport_prefs"
        const val TOKEN_DATA_KEY = "token_data"
    }
}