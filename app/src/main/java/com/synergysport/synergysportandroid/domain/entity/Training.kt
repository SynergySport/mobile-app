package com.synergysport.synergysportandroid.domain.entity

data class Training(
    val id: Int,
    val type: String,
    val date: String,
    val cores: Int,
    val time: String,
    val distance: String,
    val speed: String
)
