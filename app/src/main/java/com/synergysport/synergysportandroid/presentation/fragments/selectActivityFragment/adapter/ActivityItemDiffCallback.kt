package com.synergysport.synergysportandroid.presentation.fragments.selectActivityFragment.adapter

import androidx.recyclerview.widget.DiffUtil
import com.synergysport.synergysportandroid.domain.entity.ActivityItem

class ActivityItemDiffCallback : DiffUtil.ItemCallback<ActivityItem>() {
    override fun areItemsTheSame(oldItem: ActivityItem, newItem: ActivityItem) = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: ActivityItem, newItem: ActivityItem) = oldItem == newItem
}