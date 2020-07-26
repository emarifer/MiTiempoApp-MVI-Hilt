package com.marin.mitiempoapp.framework.datasource.geocoder

/**
 * Created by Enrique Marín on 26/07/20.
 */

interface GeocoderService {

    fun get(locality: String): List<String>
}