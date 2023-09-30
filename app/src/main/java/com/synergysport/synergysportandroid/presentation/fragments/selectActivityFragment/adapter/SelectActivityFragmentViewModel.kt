package com.synergysport.synergysportandroid.presentation.fragments.selectActivityFragment.adapter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.synergysport.synergysportandroid.domain.entity.ActivityItem
import com.synergysport.synergysportandroid.domain.useCase.GetActivitiesUseCase
import com.synergysport.synergysportandroid.domain.useCase.SaveSelectedActivityItemUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class SelectActivityFragmentViewModel @Inject constructor(
    private val getActivitiesUseCase: GetActivitiesUseCase,
    private val selectedActivityItemUseCase: SaveSelectedActivityItemUseCase
) : ViewModel() {
    private val _allActivitiesLiveData = MutableLiveData<List<ActivityItem>>()
    val allActivitiesLiveData: LiveData<List<ActivityItem>>
        get() = _allActivitiesLiveData

    private val _selectedActivityItemLiveData = MutableLiveData<ActivityItem>()

    private val _shouldCloseScreenLiveData = MutableLiveData<Unit>()
    val shouldCloseScreenLiveData: LiveData<Unit>
        get() = _shouldCloseScreenLiveData

    private val disposables = CompositeDisposable()

    fun init() {
        getAllActivities()
    }

    private fun getAllActivities() {
        disposables.add(
            getActivitiesUseCase.getAllActivities().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe({
                    _allActivitiesLiveData.value = it
                }, {
                    it.printStackTrace()
                })
        )
    }

    fun onClickActivityItem(item: ActivityItem) {
        _selectedActivityItemLiveData.value = item.copy(isSelected = true)
        _allActivitiesLiveData.value =
            _allActivitiesLiveData.value?.map {
                if (it.id == item.id) it.copy(isSelected = true) else it.copy(
                    isSelected = false
                )
            }
    }

    fun saveSelectedActivity() {
        _selectedActivityItemLiveData.value?.let {
            selectedActivityItemUseCase.saveSelectedActivity(
                it
            )
        }
        _shouldCloseScreenLiveData.value = Unit
    }

    override fun onCleared() {
        super.onCleared()
        disposables.dispose()
    }
}