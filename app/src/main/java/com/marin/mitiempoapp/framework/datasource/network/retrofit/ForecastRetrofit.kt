package com.marin.mitiempoapp.framework.datasource.network.retrofit

import com.marin.mitiempoapp.framework.datasource.network.model.ForecastNetworkEntity
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Enrique Marín on 24/07/20.
 */

interface ForecastRetrofit {

    @GET("json")
    suspend fun get(
        @Query(value = "lan")
        lan: String,
        @Query(value = "apid")
        apid: String,
        @Query(value = "ll")
        ll: String
    ): ForecastNetworkEntity
}