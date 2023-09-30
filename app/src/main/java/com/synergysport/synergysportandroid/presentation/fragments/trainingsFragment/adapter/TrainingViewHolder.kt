package com.synergysport.synergysportandroid.presentation.fragments.trainingsFragment.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.synergysport.synergysportandroid.R
import com.synergysport.synergysportandroid.domain.entity.Training

class TrainingViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    fun bind(training: Training) {
        view.findViewById<TextView>(R.id.training_type_tv).text = training.type
        view.findViewById<TextView>(R.id.training_date_tv).text = training.date
        view.findViewById<TextView>(R.id.cores_count_tv).text = training.cores.toString()
        view.findViewById<TextView>(R.id.time_count_tv).text = training.time
    }
}