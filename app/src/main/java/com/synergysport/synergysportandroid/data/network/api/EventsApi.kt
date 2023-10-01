package com.synergysport.synergysportandroid.data.network.api

import com.synergysport.synergysportandroid.data.network.dto.EventDto
import com.synergysport.synergysportandroid.data.network.dto.RegistrationToEventData
import io.reactivex.Completable
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST

interface EventsApi {
    @POST("api/events/my/")
    fun getAllEvents(): Single<List<EventDto>>

    @POST("api/events/registration/")
    fun registerToEvent(@Body registrationToEventData: RegistrationToEventData): Completable
}