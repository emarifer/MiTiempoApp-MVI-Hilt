package com.marin.mitiempoapp.framework.presentation

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.marin.mitiempoapp.business.domain.models.Forecast
import com.marin.mitiempoapp.business.domain.state.DataState
import com.marin.mitiempoapp.business.interactors.GetForecasts
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

/**
 * Created by Enrique Marín on 25/07/20.
 */

@ExperimentalCoroutinesApi
class MainViewModel
@ViewModelInject
constructor(
    private val getForecasts: GetForecasts,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _dataState: MutableLiveData<DataState<List<Forecast>>> = MutableLiveData()

    val dataState: LiveData<DataState<List<Forecast>>>
        get() = _dataState

    fun setStateEvent(mainStateEvent: MainStateEvent) {
        viewModelScope.launch {
            when(mainStateEvent) {
                is MainStateEvent.GetForecastsEvent -> {
                    _dataState.value = DataState.Loading
                    getForecasts.execute(mainStateEvent.locality)
                        .onEach { forecasts ->
                            _dataState.value = DataState.Success(forecasts)
                        }
                        .catch { e ->
                            _dataState.value = DataState.Error(e)
                        }
                        .collect()
                }
                is MainStateEvent.None -> {
                    // Hacer algo
                }
            }
        }
    }
}

sealed class MainStateEvent {

    data class GetForecastsEvent(val locality: String) : MainStateEvent()
    object None : MainStateEvent()
}