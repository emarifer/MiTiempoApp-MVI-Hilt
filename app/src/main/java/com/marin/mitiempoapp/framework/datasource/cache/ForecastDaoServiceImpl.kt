package com.marin.mitiempoapp.framework.datasource.cache

import com.marin.mitiempoapp.framework.datasource.cache.database.ForecastDao
import com.marin.mitiempoapp.framework.datasource.cache.model.ForecastCacheEntity

/**
 * Created by Enrique Marín on 24/07/20.
 */

class ForecastDaoServiceImpl
constructor(
    private val forecastDao: ForecastDao
) : ForecastDaoService {

    override suspend fun insert(forecastEntity: ForecastCacheEntity) {
        forecastDao.insert(forecastEntity)
    }

    override suspend fun get(): List<ForecastCacheEntity> = forecastDao.get()
}