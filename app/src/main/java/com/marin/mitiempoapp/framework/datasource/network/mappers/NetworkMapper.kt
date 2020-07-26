package com.marin.mitiempoapp.framework.datasource.network.mappers

import com.marin.mitiempoapp.business.domain.models.Forecast
import com.marin.mitiempoapp.business.domain.util.EntityMapper
import com.marin.mitiempoapp.framework.datasource.network.model.Day1
import com.marin.mitiempoapp.framework.datasource.network.model.ForecastNetworkEntity
import com.marin.mitiempoapp.framework.datasource.network.model.Locality
import javax.inject.Inject

/**
 * Created by Enrique Marín on 25/07/20.
 */

class NetworkMapper
@Inject
constructor() : EntityMapper<ForecastNetworkEntity, Forecast>{

    override fun mapFromEntity(entity: ForecastNetworkEntity): Forecast {
        return Forecast(
            id = 0,
            name = entity.locality!!.name,
            country = entity.locality.country,
            date = entity.day1!!.date,
            temperature_max = entity.day1.temperature_max,
            temperature_min = entity.day1.temperature_min
        )
    }

    override fun mapToEntity(domainModel: Forecast): ForecastNetworkEntity {
        return ForecastNetworkEntity(
            locality = Locality(domainModel.name, domainModel.country),
            day1 = Day1(domainModel.date, domainModel.temperature_max, domainModel.temperature_min)
        )
    }

    fun mapFromEntityList(entities: List<ForecastNetworkEntity>): List<Forecast> {

        return entities.map { mapFromEntity(it) }
    }
}