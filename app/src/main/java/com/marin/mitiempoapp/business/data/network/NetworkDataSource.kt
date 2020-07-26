package com.marin.mitiempoapp.business.data.network

import com.marin.mitiempoapp.business.domain.models.Forecast

/**
 * Created by Enrique Marín on 24/07/20.
 */

interface NetworkDataSource {

    suspend fun get(lan: String, apid: String, ll: String): Forecast
}