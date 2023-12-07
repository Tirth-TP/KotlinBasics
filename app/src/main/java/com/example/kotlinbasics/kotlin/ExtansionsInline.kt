package com.example.kotlinbasics.kotlin

/**
 * Created by Tirth Patel.
 */
fun main() {
    println("Hello Android user!".formattedString())


    calculateTimeAndRun {
        loop(1000000)
    }
}

fun String.formattedString(): String {
    return "-------------------------\n$this\n-------------------------"
}


//If this function is not inline then also output will be same but lambda will create class
// every time so it may cause performance issue, so we are using inline function here it will
//copy past code of this function whenever we call this function so it won't create extra class
// Check byte code in tools->kotlin-> show kotlin byte code-> Decompile
//You will se INSTANCE of this function if you are not using inline functions
/// It won't create any INSTANCE with inline functions

inline fun calculateTimeAndRun(fn: () -> Unit) {
    val start = System.currentTimeMillis()
    fn()
    val end = System.currentTimeMillis()
    println("Time Taken ${end - start} /ms")
}


fun loop(n: Long) {
    for (i in 1..n) {

    }
}
