package com.marin.mitiempoapp.framework.datasource.cache.mappers

import com.marin.mitiempoapp.business.domain.models.Forecast
import com.marin.mitiempoapp.business.domain.util.EntityMapper
import com.marin.mitiempoapp.framework.datasource.cache.model.ForecastCacheEntity
import javax.inject.Inject

/**
 * Created by Enrique Marín on 25/07/20.
 */

class CacheMapper
@Inject
constructor() : EntityMapper<ForecastCacheEntity, Forecast> {

    override fun mapFromEntity(entity: ForecastCacheEntity): Forecast {
        return Forecast(
            id = entity.id,
            name = entity.name,
            country = entity.country,
            date = entity.date,
            temperature_max = entity.temperature_max,
            temperature_min = entity.temperature_min
        )
    }

    override fun mapToEntity(domainModel: Forecast): ForecastCacheEntity {
        return ForecastCacheEntity(
            id = domainModel.id,
            name = domainModel.name,
            country = domainModel.country,
            date = domainModel.date,
            temperature_max = domainModel.temperature_max,
            temperature_min = domainModel.temperature_min
        )
    }

    fun mapFromEntityList(entities: List<ForecastCacheEntity>): List<Forecast> {

        return entities.map { mapFromEntity(it) }
    }
}