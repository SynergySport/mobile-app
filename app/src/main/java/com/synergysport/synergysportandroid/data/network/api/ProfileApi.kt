package com.synergysport.synergysportandroid.data.network.api

import com.synergysport.synergysportandroid.data.network.dto.ProfileDto
import io.reactivex.Single
import retrofit2.http.GET

interface ProfileApi {
    @GET("api/myprofile/")
    fun getProfileInfo(): Single<List<ProfileDto>>
}