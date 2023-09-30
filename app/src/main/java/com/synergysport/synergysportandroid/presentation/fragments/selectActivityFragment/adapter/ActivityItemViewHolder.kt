package com.synergysport.synergysportandroid.presentation.fragments.selectActivityFragment.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.synergysport.synergysportandroid.R
import com.synergysport.synergysportandroid.domain.entity.Activity

class ActivityItemViewHolder (val view: View) : RecyclerView.ViewHolder(view) {
    fun bind(activity: Activity) {
        with(view){
            findViewById<TextView>(R.id.activity_name).text = activity.name
            findViewById<ImageView>(R.id.activity_icon).setImageResource(activity.icon)
        }
    }
}