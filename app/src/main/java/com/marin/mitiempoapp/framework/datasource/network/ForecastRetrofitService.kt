package com.marin.mitiempoapp.framework.datasource.network

import com.marin.mitiempoapp.framework.datasource.network.model.ForecastNetworkEntity

/**
 * Created by Enrique Marín on 25/07/20.
 */

interface ForecastRetrofitService {

    suspend fun get(lan: String, apid: String, ll: String): ForecastNetworkEntity
}