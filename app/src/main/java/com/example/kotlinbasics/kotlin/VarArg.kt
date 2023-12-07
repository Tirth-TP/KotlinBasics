package com.example.kotlinbasics.kotlin

/**
 * Created by Tirth Patel.
 */
fun main() {
add(1,4,8,9,5,9)
add(1,2,1,2,1,2,3,4)
}

fun add(vararg values: Int){
    var sum = 0
    for (i in values) {
        sum += i
    }
    println(sum)
}

//Vararg will create list of that data type you are using here it is Int working same as array