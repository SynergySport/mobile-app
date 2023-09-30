package com.synergysport.synergysportandroid.domain.handler

import com.synergysport.synergysportandroid.domain.entity.ActivityItem

interface SelectedActivityDataHandler {
    fun saveSelectedActivity(activityItem: ActivityItem)
    fun getSelectedActivityItemId(): Int
}