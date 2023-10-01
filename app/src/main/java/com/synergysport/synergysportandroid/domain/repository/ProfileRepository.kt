package com.synergysport.synergysportandroid.domain.repository

import com.synergysport.synergysportandroid.domain.entity.Profile
import io.reactivex.Single

interface ProfileRepository {
    fun getProfileInfo(): Single<Profile>
}