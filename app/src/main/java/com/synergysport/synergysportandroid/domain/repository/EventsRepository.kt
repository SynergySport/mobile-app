package com.synergysport.synergysportandroid.domain.repository

import com.synergysport.synergysportandroid.domain.entity.EventItem
import io.reactivex.Completable
import io.reactivex.Single

interface EventsRepository {
    fun getEvents(): Single<List<EventItem>>
    fun registerToEvent(eventId: Int): Completable
}