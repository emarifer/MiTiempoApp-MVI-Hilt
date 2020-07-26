package com.marin.mitiempoapp.framework.datasource.geocoder

import android.content.Context
import android.location.Geocoder
import com.marin.mitiempoapp.R

/**
 * Created by Enrique Marín on 25/07/20.
 */

class GeocoderServiceImpl
constructor(
    context: Context,
    private val geo: Geocoder
) : GeocoderService {

    private val lan = "es"

    private val apid = context.getString(R.string.api_key)

    override fun get(locality: String): List<String> {

        val result =
            geo.getFromLocationName(locality, 1)

        val myAdress = result[0]
        val lat = myAdress.latitude
        val long = myAdress.longitude
        return listOf(lan, apid, "$lat,$long")
    }
}