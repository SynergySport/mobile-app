package com.synergysport.synergysportandroid.presentation.fragments.selectActivityFragment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.synergysport.synergysportandroid.R
import com.synergysport.synergysportandroid.domain.entity.ActivityItem

class ActivityListAdapter: ListAdapter<ActivityItem, ActivityItemViewHolder>(ActivityItemDiffCallback())  {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivityItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_activity, parent, false)
        return ActivityItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ActivityItemViewHolder, position: Int) {
        holder.bind(currentList[position])
    }
}