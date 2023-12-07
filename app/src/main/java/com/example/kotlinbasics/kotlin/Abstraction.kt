package com.example.kotlinbasics.kotlin


fun main() {

    val circle = Circle(4.0)
    println(circle.area())
    circle.display()
    /*    //Polymorphism

            val circle = Circle(4.0)
            val square: Shape = Square(4.0)

            printArea(circle)
            println(square.area())


        val shape = arrayOf(Circle(4.0), Square(4.0), Circle(4.0),Triangle(4.0,5.0))
        calculateAreas(shape)*/
    /*
        //override
      val one = OnePlus("Smart")
      one.display()
      println(one.name)
      println(one.toString())*/
}

//Abstract
abstract class Shape() {
    val name: String = "Shape"
    abstract fun area(): Double

    abstract fun display()
}

class Circle(val radius: Double) : Shape() {
    override fun area(): Double {
        return Math.PI * radius * radius
    }

    override fun display() {
        println("Circle is getting displayed")
    }
}


/*
//Overrider
open class Mobile(type: String) {

    open val name: String = ""
    open val size: Int = 5
    fun makeCall() = println("Calling from Mobile")
    fun powerOff() = println("Shutting down Mobile")
    open fun display() = println("Simple mobile display")
}

class OnePlus(typeParam: String) : Mobile(typeParam) {
    override val name: String = "OnePlus"
    override val size: Int = 5

    override fun display() {
        super.display()
        println("OnePlus Mobile Display")
    }

    override fun toString(): String {
        return "OnePlus(name='$name', size=$size)"
    }
}*/
