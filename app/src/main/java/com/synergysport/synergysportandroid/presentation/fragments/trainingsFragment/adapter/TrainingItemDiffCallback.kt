package com.synergysport.synergysportandroid.presentation.fragments.trainingsFragment.adapter

import androidx.recyclerview.widget.DiffUtil
import com.synergysport.synergysportandroid.domain.entity.Training

class TrainingItemDiffCallback : DiffUtil.ItemCallback<Training>() {
    override fun areItemsTheSame(oldItem: Training, newItem: Training) = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Training, newItem: Training) = oldItem == newItem
}