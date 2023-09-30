package com.synergysport.synergysportandroid.data.repository

import android.content.Context
import com.synergysport.synergysportandroid.data.dto.TokenData
import com.synergysport.synergysportandroid.domain.handler.TokenDataHandler
import javax.inject.Inject

class TokenDataHandlerImpl @Inject constructor(private val context: Context) : TokenDataHandler {
    override fun saveToken(tokenData: TokenData) {
        getPrefs().edit()
            .putString(TOKEN_DATA_KEY, tokenData.token).apply()
    }

    override fun getToken() = TokenData(
        getPrefs()
            .getString(TOKEN_DATA_KEY, "") ?: ""
    )

    override fun isTokenEmpty() = getPrefs().getString(TOKEN_DATA_KEY, "")
        .isNullOrBlank()

    override fun isTokenNotEmpty() = !getPrefs().getString(TOKEN_DATA_KEY, "").isNullOrBlank()

    private fun getPrefs() =
        context.getSharedPreferences(SHARED_PREFS_FILE_NAME, Context.MODE_PRIVATE)


    companion object {
        private const val SHARED_PREFS_FILE_NAME = "synergy_sport_prefs"
        private const val TOKEN_DATA_KEY = "token_data"
    }
}