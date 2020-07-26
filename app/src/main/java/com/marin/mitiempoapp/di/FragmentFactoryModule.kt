package com.marin.mitiempoapp.di

import androidx.fragment.app.FragmentFactory
import com.marin.mitiempoapp.framework.presentation.MainFragmentFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton

/**
 * Created by Enrique Marín on 24/07/20.
 */

@ExperimentalCoroutinesApi
@Module
@InstallIn(ApplicationComponent::class)
object FragmentFactoryModule {

    @Singleton
    @Provides
    fun provideMainFragmentFactory(someString: String): FragmentFactory =
        MainFragmentFactory(someString)
}