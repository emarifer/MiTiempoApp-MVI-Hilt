package com.marin.mitiempoapp.framework.datasource.cache.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.marin.mitiempoapp.framework.datasource.cache.model.ForecastCacheEntity

/**
 * Created by Enrique Marín on 25/07/20.
 */

@Dao
interface ForecastDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(forecastEntity: ForecastCacheEntity): Long

    @Query("SELECT * FROM forecasts")
    suspend fun get(): List<ForecastCacheEntity>
}