package com.marin.mitiempoapp.di

import com.marin.mitiempoapp.business.data.cache.CacheDataSource
import com.marin.mitiempoapp.business.data.geocoder.GeocoderDataSource
import com.marin.mitiempoapp.business.data.network.NetworkDataSource
import com.marin.mitiempoapp.business.interactors.GetForecasts
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

/**
 * Created by Enrique Marín on 25/07/20.
 */

@Module
@InstallIn(ApplicationComponent::class)
object InteractorsModule {

    @Singleton
    @Provides
    fun provideGetForecasts(
        cacheDataSource: CacheDataSource,
        geocoderDataSource: GeocoderDataSource,
        networkDataSource: NetworkDataSource
    ): GetForecasts = GetForecasts(cacheDataSource, geocoderDataSource, networkDataSource)
}