package com.marin.mitiempoapp.framework.datasource.cache

import com.marin.mitiempoapp.framework.datasource.cache.model.ForecastCacheEntity

/**
 * Created by Enrique Marín on 24/07/20.
 */

interface ForecastDaoService {

    suspend fun insert(forecastEntity: ForecastCacheEntity)

    suspend fun get(): List<ForecastCacheEntity>
}