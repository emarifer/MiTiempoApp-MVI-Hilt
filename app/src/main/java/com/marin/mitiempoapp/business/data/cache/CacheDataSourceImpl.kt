package com.marin.mitiempoapp.business.data.cache

import com.marin.mitiempoapp.business.domain.models.Forecast
import com.marin.mitiempoapp.framework.datasource.cache.ForecastDaoService
import com.marin.mitiempoapp.framework.datasource.cache.mappers.CacheMapper

/**
 * Created by Enrique Marín on 24/07/20.
 */

class CacheDataSourceImpl
constructor(
    private val forecastDaoService: ForecastDaoService,
    private val cacheMapper: CacheMapper
): CacheDataSource {

    override suspend fun insert(forecast: Forecast) {
        forecastDaoService.insert(cacheMapper.mapToEntity(forecast))
    }

    override suspend fun insertList(forecasts: List<Forecast>) {
        for (blog in forecasts) {
            forecastDaoService.insert(cacheMapper.mapToEntity(blog))
        }
    }

    override suspend fun get(): List<Forecast> = cacheMapper.mapFromEntityList(forecastDaoService.get())
}