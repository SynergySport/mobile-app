package com.synergysport.synergysportandroid.domain.entity

data class EventItem(
    val id: Int,
    val status: String,
    val title: String,
    val description: String,
    val units: Int,
    val date: String,
)
