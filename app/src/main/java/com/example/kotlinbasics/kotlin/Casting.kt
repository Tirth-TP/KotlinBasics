package com.example.kotlinbasics.kotlin

/**
 * Created by Tirth Patel.
 */
fun main() {
    val circle = CircleC(4.0)
    val player = PlayerC("Smiley")

    val arrObj = arrayOf(circle, player, Test())
    val arrObj1 = arrayOf(circle, player)

    for (obj in arrObj) {
        if (obj is CircleC) {
            println(obj.areaC())
            println(obj.dragC())
        } else if (obj is PlayerC) {
            obj.sayMyName()
        } else {

        }
    }
    for (obj in arrObj1) {
        if (obj is CircleC) {
            println(obj.areaC())
            println(obj.dragC())
        } else {
            (obj as PlayerC).sayMyName()
            /* Type Casting
             (In first loop it will give error if we directly use like
             this cuz there is Test() class in array list)*/
        }
    }
}

interface DraggableC {
    fun dragC()
}

abstract class ShapeC : DraggableC {
    abstract fun areaC(): Double
}

class CircleC(val radius: Double) : ShapeC() {
    override fun areaC(): Double = Math.PI * radius * radius
    override fun dragC() = println("Circle is dragging")

}

class PlayerC(val name: String) : DraggableC {
    override fun dragC() = println("$name is dragging")
    fun sayMyName() = println("Hey my name is $name")
}

class Test() {

}
