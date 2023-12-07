package com.example.kotlinbasics.kotlin

/**
 * Created by Tirth Patel.
 */
fun main() {
    var result = 3 add 6
    println(result)

    var resultM = 3 multi  6
    println(resultM)


}

infix fun Int.add(a: Int) = this + a

infix fun Int.multi(that: Int) = this * that
/*

An infix function is a function that appears in between two variables.
 Kotlin makes it easy to create functions like this.


Key points :
Infix functions are declared similarly to extension functions
They are declared by writing infix fun at the start of the function definition
When applied like 1 plus 2, the function belongs to the variable on the left (1) and the variable on the right (2) is the function parameter
Can be used to create DSLs
*/
