package com.synergysport.synergysportandroid.presentation.fragments.eventsFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.synergysport.synergysportandroid.domain.entity.EventItem
import com.synergysport.synergysportandroid.domain.useCase.GetEventsUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class EventsFragmentViewModel @Inject constructor(
    private val eventsUseCase: GetEventsUseCase
) : ViewModel() {

    private val _eventsLiveData = MutableLiveData<List<EventItem>>()
    val eventsLiveData: LiveData<List<EventItem>>
        get() = _eventsLiveData

    private val disposables = CompositeDisposable()

    fun init() {
        disposables.add(
            eventsUseCase.getEvents().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe({
                _eventsLiveData.value = it
            }, {
                it.printStackTrace()
            })
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }
}