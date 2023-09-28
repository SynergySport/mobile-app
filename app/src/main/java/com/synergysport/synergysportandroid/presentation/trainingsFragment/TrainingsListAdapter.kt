package com.synergysport.synergysportandroid.presentation.trainingsFragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.synergysport.synergysportandroid.R
import com.synergysport.synergysportandroid.domain.entity.Training

class TrainingsListAdapter : ListAdapter<Training, TrainingViewHolder>(TrainingItemDiffCallback())  {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrainingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_training, parent, false)
        return TrainingViewHolder(view)
    }

    override fun onBindViewHolder(holder: TrainingViewHolder, position: Int) {
        holder.bind(currentList[position])
    }
}