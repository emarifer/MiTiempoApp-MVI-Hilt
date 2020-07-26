package com.marin.mitiempoapp.di

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
object ProductionModule {

    @Singleton
    @Provides
    fun provideSomeString(): String =
        "Esta es una cadena de PRODUCCIÓN que estoy proporcionando para inyección"
}