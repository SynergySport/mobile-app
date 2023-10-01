package com.synergysport.synergysportandroid.data.repository

import com.synergysport.synergysportandroid.data.network.api.EventsApi
import com.synergysport.synergysportandroid.data.network.dto.RegistrationToEventData
import com.synergysport.synergysportandroid.domain.entity.EventItem
import com.synergysport.synergysportandroid.domain.repository.EventsRepository
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class EventsRepositoryImpl @Inject constructor(
    private val eventsApi: EventsApi
) : EventsRepository {
    override fun getEvents(): Single<List<EventItem>> {
        return eventsApi.getAllEvents().map {
            it.map { it.toItem() }
        }
    }

    override fun registerToEvent(eventId: Int): Completable {
        return eventsApi.registerToEvent(RegistrationToEventData(eventId))
    }
}