package com.synergysport.synergysportandroid.data.repository

import com.synergysport.synergysportandroid.data.network.api.ProfileApi
import com.synergysport.synergysportandroid.domain.entity.Profile
import com.synergysport.synergysportandroid.domain.repository.ProfileRepository
import io.reactivex.Single
import javax.inject.Inject

class ProfileRepositoryImpl @Inject constructor(
    private val profileApi: ProfileApi
) : ProfileRepository {
    override fun getProfileInfo(): Single<Profile> {
        return profileApi.getProfileInfo().flatMap { Single.just(it.first()) }.map { it.toModel() }
    }
}