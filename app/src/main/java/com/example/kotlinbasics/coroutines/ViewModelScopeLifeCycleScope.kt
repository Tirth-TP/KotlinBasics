package com.example.kotlinbasics.coroutines

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.kotlinbasics.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ViewModelScopeLifeCycleScope : AppCompatActivity() {
    lateinit var viewModel: ViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_model_scope)

        viewModel = ViewModelProvider(this)[ViewModel::class.java]

        //Here is one example of when view model destroy viewModelScope will automatically destroy

        lifecycleScope.launch {
            delay(2000) //After 2 second it will execute next lines of code
            val intent = Intent(this@ViewModelScopeLifeCycleScope, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}


/*
    When ever we launch coroutine we use scope and we have two android build-in scope
    1. ViewModelScope :
        Coroutine scope attached with your View Models.
        Coroutines in this scope will be cancelled automatically when viewModel is
        cleared. We don't need to manually cancel the coroutines.

    2. LifecycleScope :
        Coroutine scope attached with lifecycle (Activity or Fragments)
        Coroutines in this scope will be cancelled automatically when lifecycle is
        destroyed. We don't need to manually cancel the coroutines.
*/
