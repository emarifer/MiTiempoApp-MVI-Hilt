package com.marin.mitiempoapp.business.data.geocoder

/**
 * Created by Enrique Marín on 26/07/20.
 */

interface GeocoderDataSource {

    fun getCoordinates(locality: String): List<String>
}