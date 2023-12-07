package com.example.kotlinbasics.kotlin


/**
 * Created by Tirth Patel.
 */


fun main() {
    dragObjects(
        arrayOf(
            Circle1(4.0),
            Square1(4.0),
            Circle1(4.0),
            Triangle1(4.0, 5.0),
            Players("Player")
        )
    )
}

fun dragObjects(dragObj: Array<Draggable>) {
    for (drag in dragObj) {
        drag.drag()
    }
}

interface Draggable {
    fun drag()
}

abstract class Shape1 : Draggable {
    abstract fun area1(): Double
}

class Circle1(val radius: Double) : Shape1() {
    override fun area1(): Double = Math.PI * radius * radius
    override fun drag() = println("Circle is dragging")

}

class Square1(val side: Double) : Shape1() {
    override fun area1(): Double = side * side

    override fun drag() = println("Square is dragging")

}

class Triangle1(val height: Double, val base: Double) : Shape1() {
    override fun area1(): Double = 0.5 * height * base

    override fun drag() = println("Triangle is dragging")

}

class Players(val name: String) : Draggable {
    override fun drag() = println("$name is dragging")
}
