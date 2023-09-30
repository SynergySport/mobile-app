package com.synergysport.synergysportandroid.data.repository

import android.content.Context
import com.synergysport.synergysportandroid.domain.entity.ActivityItem
import com.synergysport.synergysportandroid.domain.handler.SelectedActivityDataHandler
import javax.inject.Inject

class SelectedActivityDataHandlerImpl @Inject constructor(
    private val context: Context,
) : SelectedActivityDataHandler {
    override fun saveSelectedActivity(activityItem: ActivityItem) {
        getPrefs().edit()
            .putInt(ACTIVITY_DATA_KEY, activityItem.id).apply()
    }

    override fun getSelectedActivityItemId() = getPrefs().getInt(ACTIVITY_DATA_KEY, DEFAULT_ITEM_ID)

    private fun getPrefs() =
        context.getSharedPreferences(SHARED_PREFS_FILE_NAME, Context.MODE_PRIVATE)


    companion object {
        private const val SHARED_PREFS_FILE_NAME = "synergy_sport_prefs"
        private const val ACTIVITY_DATA_KEY = "selected_activity_data"
        private const val DEFAULT_ITEM_ID = -1
    }
}