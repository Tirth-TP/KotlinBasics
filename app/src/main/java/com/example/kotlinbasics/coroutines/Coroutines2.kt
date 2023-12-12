package com.example.kotlinbasics.coroutines

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinbasics.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class Coroutines2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutines2)

        CoroutineScope(Dispatchers.Main).launch {
//            printFollowers()
//            printFollowersAsync()
            printFollowersFBInsta()
            printFollowersFBInstaAsync()
        }
    }


    /*
        Coroutines:
        with .launch method you will get job datatype */
    private suspend fun printFollowers() {
        var fbFollowers = 0
        var job = CoroutineScope(Dispatchers.IO).launch {
            fbFollowers = getFBFollowers()
        }
        job.join()      //It will hold execution from here until coroutine finish it's work
        Log.d("Tag", fbFollowers.toString()) //it will print 54 and without join() it will print 0
    }

    /*We can do same work with async method
    * It will return Deferred<T> data type which is generic
    * <T> type will be same as functions list line type here getFollowers() return Int
    * await() will call after coroutine execution finished
    * await() is a suspend function you can see suspend icon below.
    * */

    private suspend fun printFollowersAsync() {
        val job = CoroutineScope(Dispatchers.IO).async {
            getFBFollowers()
        }
        Log.d("Tag", job.await().toString())
    }

    /*
    * Here it will take 2 sec for execution coz both function have 1 second delay and both will execute
    * one after another cuz the are suspended function
    * but we with the use of async we can make this work parallel both will execute at same time*/
    private suspend fun printFollowersFBInsta() {
        CoroutineScope(Dispatchers.IO).launch {
            val fb = getFBFollowers()
            val insta = getInstaFollowers()
            Log.d("TAG", "With Launch : FB - $fb Insta - $insta")
        }
    }

    //We can use async instead
    private suspend fun printFollowersFBInstaAsync() {
        CoroutineScope(Dispatchers.IO).launch {
            val fb = async { getFBFollowers() }
            val insta = async { getInstaFollowers() }
            Log.d("TAG", "With Async : FB - ${fb.await()} Insta - ${insta.await()}")
        }
    }

/*
* Run both launch and async and see the difference of execution timing in log
* */
    private suspend fun getFBFollowers(): Int {
        delay(3000)
        return 54
    }

    private suspend fun getInstaFollowers(): Int {
        delay(3000)
        return 456
    }
}


/*
* Use Launch : when you do not care about the result. (Fire & Forget)
* Use Async : when you expect results/output from your coroutine
* Although both can be used to achieve the same functionality but it is batter to use things that are meant for it.
* */