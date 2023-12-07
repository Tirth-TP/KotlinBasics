package com.example.kotlinbasics.kotlin

/**
 * Created by Tirth Patel.
 */

fun main() {
    val arr = arrayOf(1, 2, 3)

    try {
        println(arr[5])
    } catch (ex: NullPointerException){
        println(ex)
    }
    catch (e: Exception) {
        println(e)
    }finally {
        println("I will execute no matter what")
    }
    println("This will not work")


    createUserList(5)
    createUserList(-2)
}


fun createUserList(count:Int){
    if (count<0){
        throw IllegalArgumentException("Count must be grater than 0")
    }else{
        println("User count is: $count")
    }
}

