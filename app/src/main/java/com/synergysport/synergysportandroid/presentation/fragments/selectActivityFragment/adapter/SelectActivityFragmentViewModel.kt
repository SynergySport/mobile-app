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

    private val _favoriteActivitiesLiveData = MutableLiveData<List<ActivityItem>>()
    val favoriteActivitiesLiveData: LiveData<List<ActivityItem>>
        get() = _favoriteActivitiesLiveData

    private val _selectedActivityItemLiveData = MutableLiveData<ActivityItem>()

    private val _shouldCloseScreenLiveData = MutableLiveData<Unit>()
    val shouldCloseScreenLiveData: LiveData<Unit>
        get() = _shouldCloseScreenLiveData

    private val _onClickFavoriteLiveData = MutableLiveData<Unit>()
    val onClickFavoriteLiveData: LiveData<Unit>
        get() = _onClickFavoriteLiveData

    private val _onClickAllLiveData = MutableLiveData<Unit>()
    val onClickAllLiveData: LiveData<Unit>
        get() = _onClickAllLiveData

    private val disposables = CompositeDisposable()

    fun init() {
        getFavoriteActivities()
    }

    private fun getFavoriteActivities() {
        disposables.add(
            getActivitiesUseCase.getFavoriteActivities().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe({
                    _favoriteActivitiesLiveData.value = it
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

    fun onClickFavorite() {
        _onClickFavoriteLiveData.value = Unit
        disposables.add(
            getActivitiesUseCase.getFavoriteActivities().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe({
                    _favoriteActivitiesLiveData.value = it
                }, {
                    it.printStackTrace()
                })
        )
    }

    fun onClickAll() {
        _onClickAllLiveData.value = Unit
        disposables.add(
            getActivitiesUseCase.getAllActivities().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe({
                    _allActivitiesLiveData.value = it
                }, {
                    it.printStackTrace()
                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposables.dispose()
    }
}