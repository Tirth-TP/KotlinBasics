package com.example.kotlinbasics.kotlin

import kotlin.math.pow

/**
 * Created by Tirth Patel.
 */
fun main() {
    /*  println(sum(3.0, 7.0))
      println(power(3.0, 7.0))

      var fn: (a: Double, b: Double) -> Double = ::power

      fn(4.0, 5.0)

      calculator(4.0, 5.0, ::sum)
  */
    //Lambda function

    val lambda1 = { x: Int, y: Int -> x + y }

    val multiLineLambda = {
        println("Hello Lambda")
        val a = 2 + 3
        "Hello Android"
        2  //Last line type will be the lambda function return type
    }

    val singleParam: (Int) -> Int = { x -> x + x }
    //x is a name of parameter We don't need to do this if we have single parameter
    val simpleSingleParam: (Int) -> Int = { it + it }
    //singleParam and this are equivalent just different ways to write


    //Different ways to write
    calculatorLambda(4, 7, { a, b -> a + b })
    //If we have lambda function at last then write outside parenthesis

    calculatorLambda(4, 7) { a, b -> a + b }
    calculatorLambda(4, 7) { a, b ->
        a + b
    }
    println(multiLineLambda())

    val singleParamLambda = { x: Int, y: Int -> x + y }
//    val lambda2: (Int) -> Int =
//        { x -> x * x }  //If we are declaring lambda type then don't need to declare parameter type
//
//    val sayHi = { msg: String -> println("sdgndt") }
//    val ugg: (String) -> Unit = { msg -> println("sdgndt") }
}

fun sum(a: Double, b: Double): Double {
    return a + b
}

fun power(a: Double, b: Double): Double {
    return a.pow(b)
}

//Higher order functions
fun calculator(a: Double, b: Double, gn: (Double, Double) -> Double) {
    val result = gn(a, b)
    println(result)
}

//In Kotlin, a function which can accept a function as a parameter or can
// return a function is called a Higher-Order function.

//Function which are passing must have same return type and parameter also have same data type


//Lambda function

fun multi(a: Int, b: Int): Int = a * b

fun calculatorLambda(a: Int, b: Int, op: (Int, Int) -> Int): Int {
    return op(a, b)
}
