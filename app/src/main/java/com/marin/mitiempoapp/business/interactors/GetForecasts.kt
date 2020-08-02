package com.marin.mitiempoapp.business.interactors

import com.marin.mitiempoapp.business.data.cache.CacheDataSource
import com.marin.mitiempoapp.business.data.geocoder.GeocoderDataSource
import com.marin.mitiempoapp.business.data.network.NetworkDataSource
import com.marin.mitiempoapp.business.domain.models.Forecast
import com.marin.mitiempoapp.business.domain.state.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * Created by Enrique Marín on 25/07/20.
 */

class GetForecasts
constructor(
    private val cacheDataSource: CacheDataSource,
    private val geocoderDataSource: GeocoderDataSource,
    private val networkDataSource: NetworkDataSource
) {

    suspend fun execute(locality: String): Flow<DataState<List<Forecast>>> = flow {
        emit(DataState.Loading)
        //delay(1000) // Para que dé tiempo de ver el progressBar. No necesario en producción.
        try {
            val location = geocoderDataSource.getCoordinates(locality)
            val lan = location[0]
            val apid = location[1]
            val coordinates = location[2]
            val networkForecast = networkDataSource.get(lan, apid, coordinates)
            cacheDataSource.insert(networkForecast)
            val cachedForecast = cacheDataSource.get()
            emit(DataState.Success(cachedForecast))
        } catch (e: Exception) {
            emit(DataState.Error(e))
        }
    }
}

/**
 * Muestra carga / barra de progreso
 * Obtiene las coordenadas geográficas de la localidad buscada mediante
 * de Geocoder (añadiendo el idioma de búsqueda / presentación y la API KEY)
 * Obtiene los objetos forecast de la red
 * Inserta los objetos forecast en caché (base de datos Room)
 * Emite, a través de livedata, la lista de objetos forecast para que se muestre en la UI
 */