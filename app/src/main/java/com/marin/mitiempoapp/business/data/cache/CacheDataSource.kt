package com.marin.mitiempoapp.business.data.cache

import com.marin.mitiempoapp.business.domain.models.Forecast

/**
 * Created by Enrique Marín on 24/07/20.
 */

interface CacheDataSource {

    suspend fun insert(forecast: Forecast)

    suspend fun insertList(forecasts: List<Forecast>)

    suspend fun get(): List<Forecast>
}