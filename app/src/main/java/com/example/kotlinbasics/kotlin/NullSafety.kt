package com.example.kotlinbasics.kotlin

/**
 * Created by Tirth Patel.
 */
fun main() {
    var gender: String = "Male"  // Non nullable data type
    var gender2: String? = null    // Nullable data type
    var isAdult: Boolean? = true

    if (gender2 != null) {
        println(gender2.uppercase())
    }

    println(gender2?.uppercase())  //Safe Call It will check if gender2 is null then it will not call uppercase() method and print null


    // Suppose I want to call multiple statements if object is not null then we use let

    gender2?.let {      //let is a lambda function
        println("Line 1")
        println("Line 2 $gender2")  //It can't be null inside let block
        println("Line 3 $it")  // it is pointing to the object where let is called
    }

    val selectedValue = gender2 //selectedValue is assigned as a String? (nullable Data type)

    val selectedValue2 = gender2 ?: "NA" // selectedValue2 is assigned as a String non nullable
    //If gender2 is null then it will assign NA to selectedValue2


    val value = gender2!!.uppercase()   //Non null asserted
    // It will throw error if object is null and if object hase value then it will call uppercase(

}