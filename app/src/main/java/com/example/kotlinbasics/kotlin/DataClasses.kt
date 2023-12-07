package com.example.kotlinbasics.kotlin

/**
 * Created by Tirth Patel.
 */

fun main() {
    val p1 = Person(1,"First")
    val p2 = Person(1,"First")

    println(p1)  // Default it is calling toString()
    println(p2)
    println(p1.hashCode())
    println(p1 ==p2)   //p1.equals(p2)  //Data are same but objects are not
    println("--------------------------------")

    // If we make Person Class A Data class then Output will be different


    val d1 = Person1(1,"First")
    val d2 = Person1(1,"First")

    println(d1)  // Default it is calling toString() but It will give formatted output
    println(d2)
    println(d1.hashCode())
    println(d1 ==d2)     //Data are same now
    println("--------------------------------")

//Data class Features
    val d3 = d1.copy(id = 2)
    println(d3)

    val (id,name) = d1
    println(id)
    println(name)
    println(d1.component1())
}


class Person(val id: Int, val name: String){}
data class Person1(val id: Int, val name: String){}

//At-least one parameter needed for data