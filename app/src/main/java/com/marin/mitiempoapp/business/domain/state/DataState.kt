package com.marin.mitiempoapp.business.domain.state

/**
 * Created by Enrique Marín on 25/07/20.
 */

sealed class DataState<out R> {

    data class Success<out T>(val data: T) : DataState<T>()
    data class Error(val exception: Throwable) : DataState<Nothing>()
    object Loading : DataState<Nothing>()
}