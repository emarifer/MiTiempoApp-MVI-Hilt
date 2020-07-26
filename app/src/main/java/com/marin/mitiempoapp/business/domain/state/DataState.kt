package com.marin.mitiempoapp.business.domain.state

import java.lang.Exception

/**
 * Created by Enrique Marín on 25/07/20.
 */

sealed class DataState<out R> {

    data class Success<out T>(val data: T) : DataState<T>()
    data class Error(val exception: Exception) : DataState<Nothing>()
    object Loading : DataState<Nothing>()
}