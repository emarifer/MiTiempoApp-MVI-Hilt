package com.marin.mitiempoapp.framework.datasource.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Enrique Marín on 25/07/20.
 */

data class ForecastNetworkEntity(

    @SerializedName("locality")
    @Expose
    val locality: Locality? = null,

    @SerializedName("day1")
    @Expose
    val day1: Day1? = null
)

data class Locality(

    @SerializedName("name")
    @Expose
    val name: String = "",

    @SerializedName("country")
    @Expose
    val country: String = ""
)

data class Day1(

    @SerializedName("date")
    @Expose
    val date: String = "",

    @SerializedName("temperature_max")
    @Expose
    val temperature_max: String = "",

    @SerializedName("temperature_min")
    @Expose
    val temperature_min: String = ""
)