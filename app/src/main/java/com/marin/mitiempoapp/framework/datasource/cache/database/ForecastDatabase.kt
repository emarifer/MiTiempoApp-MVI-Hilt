package com.marin.mitiempoapp.framework.datasource.cache.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.marin.mitiempoapp.framework.datasource.cache.model.ForecastCacheEntity

/**
 * Created by Enrique Marín on 25/07/20.
 */

@Database(entities = [ForecastCacheEntity::class], version = 1)
abstract class ForecastDatabase : RoomDatabase() {

    abstract fun forecastDao(): ForecastDao

    companion object {

        val DATABASE_NAME: String = "forecast_db"
    }
}