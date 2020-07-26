package com.marin.mitiempoapp.business.domain.models

/**
 * Created by Enrique Marín on 25/07/20.
 */

data class Forecast(

    var id: Int,
    val name: String,
    val country: String,
    val date: String,
    val temperature_max: String,
    val temperature_min: String
)