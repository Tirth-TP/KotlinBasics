package com.example.kotlinbasics.coroutines

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


/**
 * Created by Tirth Patel.
 */
class ViewModel : ViewModel() {
    private val TAG = "KOTLINFUN"

    init {
        viewModelScope.launch {
            while (true) {
                delay(500)
                Log.d(TAG, "Hello Android")
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        Log.d(TAG, "View Model Destroyed")
    }
}