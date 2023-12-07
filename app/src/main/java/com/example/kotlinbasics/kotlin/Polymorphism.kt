package com.example.kotlinbasics.kotlin

/**
 * Created by Tirth Patel.
 */
fun main() {

    val circle = CircleP(4.0)
    val square: ShapeP = Square(4.0)

    printArea(circle)
    println(square.area())


    val shape = arrayOf(CircleP(4.0), Square(4.0), CircleP(4.0), Triangle(4.0, 5.0))
    calculateAreas(shape)

}




fun calculateAreas(shapes: Array<ShapeP>) {
    for (shape in shapes) {
        println(shape.area())
    }
}

fun printArea(shape: ShapeP) {
    println(shape.area())
}

open class ShapeP() {
    open fun area(): Double {
        return 0.0
    }
}

class CircleP(val radius: Double) : ShapeP() {
    override fun area(): Double {
        return Math.PI * radius * radius
    }
}

class Square(val side: Double) : ShapeP() {
    override fun area(): Double {
        return side * side
    }
}

class Triangle(val height: Double, val base: Double) : ShapeP() {
    override fun area(): Double {
        return 0.5 * height * base
    }
}
