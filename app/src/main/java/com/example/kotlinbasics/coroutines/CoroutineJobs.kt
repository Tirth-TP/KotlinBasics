package com.example.kotlinbasics.coroutines

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinbasics.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

class CoroutineJobs : AppCompatActivity() {
    private val TAG = "KOTLINFUN"
    private val TAG2 = "COROUTINE"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutine_jobs)

        GlobalScope.launch {
            execute()
        }
    }

    private suspend fun execute() {
        val parentJob = GlobalScope.launch(Dispatchers.Main) {
//            Log.d(TAG, "Parent: $coroutineContext")

            Log.d(TAG, "Parent Started")

            //If we will not define explicitly any context then it will consider parents context
            // Here parents context is Dispatchers.Main

            val childJob = launch {
//                Log.d(TAG, "Child1: $coroutineContext")

                Log.d(TAG, "Child Job Started")
                delay(5000)
                Log.d(TAG, "Child Job Ended")


                /*
                //lets see cancel exception with try catch

                try {
                    Log.d(TAG, "Child Job Started")
                    delay(5000)
                    Log.d(TAG, "Child Job Ended")
                } catch (e: Exception) {
                    Log.d(TAG, "Child Job Cancelled")
                }*/
            }

            //We can explicitly define like this
            /*val childJob2 = launch(Dispatchers.IO) {
                Log.d(TAG, "Child2: $coroutineContext")
            }*/

            delay(3000)
            /*childJob.cancel() // It will cancel child job after 3 seconds
            // cancel method will throw cancel exception to parent and parent will check and cancel child job
            Log.d(TAG, "Child Job Cancelled")*/
            Log.d(TAG, "Parent Job Ended")
        }

        /* delay(1000)
         parentJob.cancel()  //It will cancel execution after 1 second, Child job will also destroy*/

        parentJob.join() //It will suspend parent coroutine after complete child job then parent will completed
        //Parent will wait for child to finish and then parent will go into completed state
        Log.d(TAG, "Parent Job Completed")


        //
        val longTask = CoroutineScope(Dispatchers.IO).launch {
            for (i in 1..500) {
                if (isActive) {
                    executeLongRunningTask()
                    Log.d(TAG2, i.toString())
                }
            }
        }

       /* We need to check isActive othervise our thread will busy in executing long running task
        it will not check corotine is in cancle state or in active state
        So we need to check it by ourselves */

        delay(1000)
        Log.d(TAG2, "Canceling Job")
        longTask.cancel()
        longTask.join()
        Log.d(TAG2, "Parent Job Completed")
    }


    private fun executeLongRunningTask() {
        for (i in 1..100000000L) {

        }
    }
}