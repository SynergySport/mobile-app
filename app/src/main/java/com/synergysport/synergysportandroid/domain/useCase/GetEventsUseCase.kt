package com.synergysport.synergysportandroid.domain.useCase

import com.synergysport.synergysportandroid.domain.entity.EventItem
import com.synergysport.synergysportandroid.domain.repository.EventsRepository
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class GetEventsUseCase @Inject constructor(
    private val eventsRepository: EventsRepository
) {
    fun getEvents(): Single<List<EventItem>> = eventsRepository.getEvents()
    fun registerToEvent(eventId: Int): Completable = eventsRepository.registerToEvent(eventId)
}