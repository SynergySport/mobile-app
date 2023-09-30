package com.synergysport.synergysportandroid.presentation.fragments.selectActivityFragment.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.synergysport.synergysportandroid.R
import com.synergysport.synergysportandroid.domain.entity.ActivityItem

class ActivityItemViewHolder (val view: View) : RecyclerView.ViewHolder(view) {
    fun bind(activityItem: ActivityItem) {
        with(view){
            findViewById<TextView>(R.id.activity_name).text = activityItem.name
            findViewById<ImageView>(R.id.activity_icon).setImageResource(activityItem.icon)
        }
    }
}