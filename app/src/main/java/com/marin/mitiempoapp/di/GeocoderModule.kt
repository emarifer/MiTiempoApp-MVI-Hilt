package com.marin.mitiempoapp.di

import android.content.Context
import android.location.Geocoder
import com.marin.mitiempoapp.business.data.cache.CacheDataSource
import com.marin.mitiempoapp.business.data.cache.CacheDataSourceImpl
import com.marin.mitiempoapp.business.data.geocoder.GeocoderDataSource
import com.marin.mitiempoapp.business.data.geocoder.GeocoderDataSourceImpl
import com.marin.mitiempoapp.framework.datasource.cache.ForecastDaoService
import com.marin.mitiempoapp.framework.datasource.cache.mappers.CacheMapper
import com.marin.mitiempoapp.framework.datasource.geocoder.GeocoderService
import com.marin.mitiempoapp.framework.datasource.geocoder.GeocoderServiceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

/**
 * Created by Enrique Marín on 25/07/20.
 */

@Module
@InstallIn(ApplicationComponent::class)
object GeocoderModule {

    @Singleton
    @Provides
    fun provideGeocoder(@ApplicationContext context: Context): Geocoder =
        Geocoder(context)

    @Singleton
    @Provides
    fun provideGeocoderService(@ApplicationContext context: Context, geo: Geocoder): GeocoderService =
        GeocoderServiceImpl(context, geo)

    @Singleton
    @Provides
    fun provideGeocoderDataSource(
        geocoderService: GeocoderService
    ) : GeocoderDataSource = GeocoderDataSourceImpl(geocoderService)
}