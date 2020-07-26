package com.marin.mitiempoapp.business.data.network

import com.marin.mitiempoapp.business.domain.models.Forecast
import com.marin.mitiempoapp.framework.datasource.network.ForecastRetrofitService
import com.marin.mitiempoapp.framework.datasource.network.mappers.NetworkMapper

/**
 * Created by Enrique Marín on 24/07/20.
 */

class NetworkDataSourceImpl
constructor(
    private val forecastRetrofitService: ForecastRetrofitService,
    private val networkMapper: NetworkMapper
) : NetworkDataSource {

    override suspend fun get(lan: String, apid: String, ll: String): Forecast =
        networkMapper.mapFromEntity(forecastRetrofitService.get(lan, apid, ll))
}