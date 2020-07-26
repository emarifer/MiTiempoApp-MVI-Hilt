package com.marin.mitiempoapp.di

import android.content.Context
import androidx.room.Room
import com.marin.mitiempoapp.business.data.cache.CacheDataSource
import com.marin.mitiempoapp.business.data.cache.CacheDataSourceImpl
import com.marin.mitiempoapp.business.domain.models.Forecast
import com.marin.mitiempoapp.business.domain.util.EntityMapper
import com.marin.mitiempoapp.framework.datasource.cache.ForecastDaoService
import com.marin.mitiempoapp.framework.datasource.cache.ForecastDaoServiceImpl
import com.marin.mitiempoapp.framework.datasource.cache.database.ForecastDao
import com.marin.mitiempoapp.framework.datasource.cache.database.ForecastDatabase
import com.marin.mitiempoapp.framework.datasource.cache.mappers.CacheMapper
import com.marin.mitiempoapp.framework.datasource.cache.model.ForecastCacheEntity
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
object CacheModule {

    @Singleton
    @Provides
    fun provideCacheMapper(): EntityMapper<ForecastCacheEntity, Forecast> = CacheMapper()

    @Singleton
    @Provides
    fun provideForecastDb(@ApplicationContext context: Context): ForecastDatabase {
        return Room.databaseBuilder(
            context,
            ForecastDatabase::class.java,
            ForecastDatabase.DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideForecastDao(forecastDatabase: ForecastDatabase): ForecastDao = forecastDatabase.forecastDao()

    @Singleton
    @Provides
    fun provideForecastDaoService(forecastDao: ForecastDao): ForecastDaoService = ForecastDaoServiceImpl(forecastDao)

    @Singleton
    @Provides
    fun provideCacheDataSource(
        forecastDaoService: ForecastDaoService,
        cacheMapper: CacheMapper
    ) : CacheDataSource = CacheDataSourceImpl(forecastDaoService, cacheMapper)
}