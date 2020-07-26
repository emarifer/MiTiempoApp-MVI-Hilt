package com.marin.mitiempoapp.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.marin.mitiempoapp.business.data.network.NetworkDataSource
import com.marin.mitiempoapp.business.data.network.NetworkDataSourceImpl
import com.marin.mitiempoapp.business.domain.models.Forecast
import com.marin.mitiempoapp.business.domain.util.EntityMapper
import com.marin.mitiempoapp.framework.datasource.network.ForecastRetrofitService
import com.marin.mitiempoapp.framework.datasource.network.ForecastRetrofitServiceImpl
import com.marin.mitiempoapp.framework.datasource.network.mappers.NetworkMapper
import com.marin.mitiempoapp.framework.datasource.network.model.ForecastNetworkEntity
import com.marin.mitiempoapp.framework.datasource.network.retrofit.ForecastRetrofit
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by Enrique Marín on 25/07/20.
 */

@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideNetworkMapper(): EntityMapper<ForecastNetworkEntity, Forecast> = NetworkMapper()

    @Singleton
    @Provides
    fun provideGsonBuilder(): Gson {
        return GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create()
    }

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson): Retrofit.Builder {
        return Retrofit.Builder()
            .baseUrl("https://api.tutiempo.net/")
            .addConverterFactory(GsonConverterFactory.create(gson))
    }

    @Singleton
    @Provides
    fun provideForecastService(retrofit: Retrofit.Builder): ForecastRetrofit {
        return retrofit
            .build()
            .create(ForecastRetrofit::class.java)
    }

    @Singleton
    @Provides
    fun provideRetrofitService(
        forecastRetrofit: ForecastRetrofit
    ): ForecastRetrofitService = ForecastRetrofitServiceImpl(forecastRetrofit)



    @Singleton
    @Provides
    fun provideNetworkDataSource(
        forecastRetrofitService: ForecastRetrofitService,
        networkMapper: NetworkMapper
    ): NetworkDataSource = NetworkDataSourceImpl(forecastRetrofitService, networkMapper)
}