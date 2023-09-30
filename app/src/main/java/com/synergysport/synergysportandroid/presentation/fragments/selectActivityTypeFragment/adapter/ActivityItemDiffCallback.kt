package com.synergysport.synergysportandroid.presentation.fragments.selectActivityTypeFragment.adapter

import androidx.recyclerview.widget.DiffUtil
import com.synergysport.synergysportandroid.domain.entity.Activity

class ActivityItemDiffCallback : DiffUtil.ItemCallback<Activity>() {
    override fun areItemsTheSame(oldItem: Activity, newItem: Activity) = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Activity, newItem: Activity) = oldItem == newItem
}