package com.marin.mitiempoapp.framework.datasource.network

import com.marin.mitiempoapp.framework.datasource.network.model.ForecastNetworkEntity
import com.marin.mitiempoapp.framework.datasource.network.retrofit.ForecastRetrofit

/**
 * Created by Enrique Marín on 24/07/20.
 */

class ForecastRetrofitServiceImpl
constructor(
    private val forecastRetrofit: ForecastRetrofit
) : ForecastRetrofitService {

    override suspend fun get(lan: String, apid: String, ll: String): ForecastNetworkEntity =
        forecastRetrofit.get(lan, apid, ll)
}