package com.synergysport.synergysportandroid.presentation.fragments.eventsFragment.adapter

import androidx.recyclerview.widget.DiffUtil
import com.synergysport.synergysportandroid.domain.entity.EventItem

class EventItemDiffCallback : DiffUtil.ItemCallback<EventItem>() {
    override fun areItemsTheSame(oldItem: EventItem, newItem: EventItem) = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: EventItem, newItem: EventItem) = oldItem == newItem
}