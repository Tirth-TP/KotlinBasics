package com.example.kotlinbasics.kotlin

/**
 * Created by Tirth Patel.
 */
fun main() {
    val day = Days.FRIDAY
    println(day)
    println(day.number)

    day.printFormattedDays()

    /*for (i in Days.values()){
        println(i)
    }*/

    //Sealed Class

    val tile: Tile = Red("Mashroom", 20)
    val points = when (tile) {
        is Blue -> tile.points * 2
        is Red -> tile.points * 5
    }

    println(points)
}

enum class Days(val number: Int) {
    SUNDAY(1), MONDAY(2), TUESDAY(3), WEDNESDAY(4), THURSDAY(5), FRIDAY(6), SATURDAY(7);

    fun printFormattedDays() {
        println("Day is $this")  //this is pointing to current object
    }
}

sealed class Tile
class Red(val type: String, val points: Int) : Tile()
class Blue(val points: Int) : Tile()


/*
* In Enum class we restricts value, We have single instance of value and we can use any one from it.
* Sealed class we are restricts type, We can create multiple object which have different state
* Sealed class benefit When we define when we there is no need for else we have pre defined possibility Red and Blue.
* */