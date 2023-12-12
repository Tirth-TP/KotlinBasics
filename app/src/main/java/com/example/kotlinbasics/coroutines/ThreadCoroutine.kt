package com.example.kotlinbasics.coroutines

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinbasics.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.yield

/*Checkout this : https://youtu.be/icShqRqEQgA?list=PLRKyZvuMYSIN-P6oJDEu3zGLl5UQNvx9y*/
class ThreadCoroutine : AppCompatActivity() {
    lateinit var btnIncrement: Button
    lateinit var btnLongTask: Button
    lateinit var txtTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thread_coroutine)
        btnIncrement = findViewById(R.id.btnIncrement)
        btnLongTask = findViewById(R.id.btnLongTask)
        txtTextView = findViewById(R.id.textView)


        Log.e("Tag", "onCreate() --> ${Thread.currentThread().name}")
        btnIncrement.setOnClickListener {
            Log.e("Tag", "onCreate() -- On Click --> ${Thread.currentThread().name}")
            txtTextView.text = "${txtTextView.text.toString().toInt() + 1}"
        }

        //Coroutine Suspended function
        CoroutineScope(Dispatchers.Main).launch {
            task1()
        }
        CoroutineScope(Dispatchers.Main).launch {
            task2()
        }





        btnLongTask.setOnClickListener {

            /*     Here we are creating new thread to perform this operation
                 If we are not creating a new thread than until this operation perform we can't do anything else
                 But creating new thread is not memory efficient 1 thread takes around 2MB of memory
                 And we have limitations for creating new threads
                 So In kotlin we can use Coroutines to solve this problem*/

            /* thread(start = true) {
                 Log.e("Tag", "onCreate() -- Thread --> ${Thread.currentThread().name}")
                 for (i in 1..1000000000L) {

                 }
             }*/


            /*Coroutines
            Coroutines will run on top of threads. (It will execute on thread)

            We need for Coroutines :

            1. Coroutines Scope (Define Lifetime of coroutines, Define boundary in which coroutine will execute)
            2. Coroutines Context (Define on which thread coroutines will execute)

            Dispatcher :

            Dispatcher is a way to define threads on which Coroutines are executed.
            Predefined Dispatcher:
            1. Dispatcher.IO
            2. Dispatcher.Main
            3. Dispatcher.Default
            4. Unconfined dispatcher


            - A suspended function is a function that can be paused and later resumed
            - When a suspended function is invoked, it can perform long-running or asynchronous tasks without blocking the thread
            - Help coroutine to suspend the computation at the particular point
            - For that we need to specifies suspension point
            - It will automatic define suspension point when there is some time taking operation
              came like API call, Database operation,File reading...
            */


            CoroutineScope(Dispatchers.IO).launch {
                Log.e(
                    "Tag",
                    "onCreate() -- Coroutines 1--> ${Thread.currentThread().name}"
                )
                for (i in 1..1000000000L) {

                }
            }    //This coroutine function is not such different from creating new thread

            //GlobalScope is connected with full application
            GlobalScope.launch(Dispatchers.Main) {
                Log.e(
                    "Tag",
                    "onCreate() -- Coroutines 2--> ${Thread.currentThread().name}"
                )
            }

            //MainScope is connected with Main Activity
            MainScope().launch(Dispatchers.Default) {
                Log.e(
                    "Tag",
                    "onCreate() -- Coroutines 3--> ${Thread.currentThread().name}"
                )
            }

        }
    }

    //Suspended Function
    suspend fun task1() {
        Log.d("TAG", "Starting Task 1")
        yield()
//        delay(1000)
        Log.d("TAG", "Ending Task 1")
    }

    suspend fun task2() {
        Log.d("TAG", "Starting Task 2")
        yield()
//        delay(1000)
        Log.d("TAG", "Starting Task 2")
    }

    //We have to use yield or delay here coz there is no such time consuming task are here or else
    //it will auto detect it. And show special suspend function call icon on left.
}
