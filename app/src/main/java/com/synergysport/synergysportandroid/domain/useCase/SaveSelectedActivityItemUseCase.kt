package com.synergysport.synergysportandroid.domain.useCase

import com.synergysport.synergysportandroid.domain.entity.ActivityItem
import com.synergysport.synergysportandroid.domain.handler.SelectedActivityDataHandler
import javax.inject.Inject

class SaveSelectedActivityItemUseCase @Inject constructor(
    private val selectedActivityDataHandler: SelectedActivityDataHandler
) {
    fun saveSelectedActivity(activityItem: ActivityItem) =
        selectedActivityDataHandler.saveSelectedActivity(activityItem)
}