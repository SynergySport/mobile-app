package com.synergysport.synergysportandroid.presentation.fragments.eventsFragment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.synergysport.synergysportandroid.R
import com.synergysport.synergysportandroid.domain.entity.EventItem
import com.synergysport.synergysportandroid.domain.entity.Training
import com.synergysport.synergysportandroid.presentation.fragments.trainingsFragment.adapter.TrainingItemDiffCallback
import com.synergysport.synergysportandroid.presentation.fragments.trainingsFragment.adapter.TrainingViewHolder

class EventsListAdapter : ListAdapter<EventItem, EventViewHolder>(EventItemDiffCallback())  {

    var registerAction: ((Int) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_event, parent, false)
        return EventViewHolder(view, registerAction)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        holder.bind(currentList[position])
    }
}