package com.marin.mitiempoapp.framework.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.marin.mitiempoapp.R
import com.marin.mitiempoapp.business.domain.models.Forecast
import com.marin.mitiempoapp.business.domain.state.DataState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.coroutines.ExperimentalCoroutinesApi

/**
 * Created by Enrique Marín on 25/07/20.
 */

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class MainFragment
constructor(
   private val someString: String
): Fragment(R.layout.fragment_main) {

    private val TAG: String = "AppDebug"

    private val STARTING_TOWN = "sevilla"

    private val viewModel: MainViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        subscribeObservers()
        viewModel.setStateEvent(MainStateEvent.GetForecastsEvent(STARTING_TOWN)) // Establece estado inicial
        setupSearchView()

        Log.d(TAG, "Here is some string: $someString")
    }

    private fun subscribeObservers() {
        viewModel.dataState.observe(viewLifecycleOwner, Observer { dataState ->
            when(dataState) {
                is DataState.Success -> {
                    displayProgressBar(false)
                    displayData(dataState.data)
                }
                is DataState.Error -> {
                    displayProgressBar(false)
                    displayError(dataState.exception.message)
                }
                is DataState.Loading -> {
                    displayProgressBar(true)
                }
            }

        })
    }

    private fun setupSearchView() {
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                viewModel.setStateEvent(MainStateEvent.GetForecastsEvent(query!!))
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

        })
    }

    private fun displayProgressBar(isDisplayed: Boolean) {
        progressBar.visibility = if (isDisplayed) View.VISIBLE else View.GONE
    }

    @SuppressLint("SetTextI18n")
    private fun displayData(forecasts: List<Forecast>) {

        val forecast = forecasts[0]

        txt_name.text = forecast.name
        txt_country.text = forecast.country
        txt_date.text = "Fecha: ${dateFormat(forecast.date)}"
        txt_max.text = "Temperatura máx: ${forecast.temperature_max} ºC"
        txt_min.text = "Temperatura mín: ${forecast.temperature_min} ºC"
    }

    @SuppressLint("SetTextI18n")
    private fun displayError(message: String?) {
        if (message != null) txt_name.text = message else txt_name.text = "Error desconocido"
        txt_country.text = ""
        txt_date.text = ""
        txt_max.text = ""
        txt_min.text = ""
    }

    private fun dateFormat(date: String): String {
        val dateList = date.split("-")
        val year = dateList[0]
        var month = dateList[1]
        var day = dateList[2]

        if(month.length == 1) month = "0$month"

        if(day.length == 1) day = "0$day"

        return "$day/$month/$year"
    }
}