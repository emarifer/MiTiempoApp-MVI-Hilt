package com.marin.mitiempoapp.business.data.geocoder

import com.marin.mitiempoapp.framework.datasource.geocoder.GeocoderService

/**
 * Created by Enrique Marín on 26/07/20.
 */

class GeocoderDataSourceImpl
constructor(
    private val geocoderService: GeocoderService
): GeocoderDataSource {

    override fun getCoordinates(locality: String): List<String> = geocoderService.get(locality)
}