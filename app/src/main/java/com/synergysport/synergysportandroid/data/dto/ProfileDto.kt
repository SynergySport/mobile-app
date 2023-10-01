package com.synergysport.synergysportandroid.data.dto

import com.google.gson.annotations.SerializedName
import com.synergysport.synergysportandroid.domain.entity.Profile

data class ProfileDto(
    @SerializedName("full_name") val full_name: String,
    @SerializedName("company") val company: String,
    @SerializedName("department_str") val department_str: String,
    @SerializedName("role_str") val role_str: String,
    @SerializedName("email") val email: String,
    @SerializedName("telegram") val telegram: String
) {
    fun toModel() = Profile(
        full_name, company, department_str, role_str, email, telegram
    )
}
