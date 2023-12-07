package com.example.kotlinbasics.kotlin

/**
 * Created by Tirth Patel.
 */
fun main() {


    val one = OnePlus("Smart")
    one.display()
    println(one.name)
    println(one.toString())
}




class Circle(val radius: Double) : Shape() {
    override fun area(): Double {
        return Math.PI * radius * radius
    }

    override fun display() {
        println("Circle is getting displayed")
    }
}

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
}
