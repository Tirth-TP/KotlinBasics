package com.example.kotlinbasics.kotlin


fun main() {

    val circle = Circle(4.0)
    println(circle.area())
    circle.display()

}

//Abstract
abstract class Shape() {
    val name: String = "Shape"
    abstract fun area(): Double

    abstract fun display()
}
