package com.marin.mitiempoapp.framework.datasource.cache.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Enrique Marín on 25/07/20.
 */

@Entity(tableName = "forecasts")
data class ForecastCacheEntity(

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    var id: Int = 0,

    @ColumnInfo(name = "name")
    val name: String = "",

    @ColumnInfo(name = "country")
    val country: String = "",

    @ColumnInfo(name = "date")
    val date: String = "",

    @ColumnInfo(name = "temperature_max")
    val temperature_max: String = "",

    @ColumnInfo(name = "temperature_min")
    val temperature_min: String = ""
)