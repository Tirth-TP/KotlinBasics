package com.example.kotlinbasics.coroutines

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinbasics.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

class WithContextRunBlocking : AppCompatActivity() {

    private val TAG = "KOTLINFUN"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_with_context_run_blocking)

        GlobalScope.launch {
            executeTask()
        }
    }

    private suspend fun executeTask() {
        /*  Log.d(TAG, "Before")  //1st output
          GlobalScope.launch {
              delay(1000)
              Log.d(TAG, "Inside")  //3rd output
          }
          Log.d(TAG, "After")  //2st output
  */
        /*Here it will execute Before and than create new thread for global
        and execute next line which is Inside and than after 1 second it will print Inside
        This will not block the code.*/


        //With Context

        Log.d(TAG, "Before")  //1st output
        withContext(Dispatchers.IO) {
            delay(1000)
            Log.d(TAG, "Inside")  //2nd output
        }
        Log.d(TAG, "After")  //3rd output

        /*WithContext is a blocking call it will block coroutine not thread
          This is a suspend function
          Once it will complete than next code will be executed.*/
    }
}

/*Suppose we are performing some task from IO thread and after data receive from API
* we want to update UI, and generally we use main thread for UI update.
* so we can use withContext to pass that from IO thread to Main thread
* That's how we do context switching in coroutines */


fun main3() {
    GlobalScope.launch {
        delay(1000)
        println("World")  //It will not print this cuz process will finish after print Hello
    }
    println("Hello")
    Thread.sleep(2000)  //So overcome this issue we can stop thread for with time declaration or we can use run blocking

    //In android out application continue running so we can't face this issue but in console and test cases we get this
}

fun main2() {
    runBlocking {   //It will hold thread until coroutine finish task
        launch {  //runBlocking is create coroutine scope so we can direct use launch
            delay(1000)
            println("World")
        }
        println("Hello")
    }
}

//We can also write it like this

fun main() = runBlocking {

    launch {
        delay(1000)
        println("World")
    }
    println("Hello")
}