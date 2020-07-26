package com.marin.mitiempoapp.framework.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.marin.mitiempoapp.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

/**
 * Created by Enrique Marín on 25/07/20.
 */

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val TAG: String = "AppDebug"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}