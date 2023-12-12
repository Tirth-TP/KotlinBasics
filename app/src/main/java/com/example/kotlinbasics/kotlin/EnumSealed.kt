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
    SUNDAY(1),
    MONDAY(2),
    TUESDAY(3),
    WEDNESDAY(4),
    THURSDAY(5),
    FRIDAY(6),
    SATURDAY(7);

    fun printFormattedDays() {
        println("Day is $this")  //this is pointing to current object
    }
}

enum class Color {
    RED, GREEN, BLUE
}

fun getDescription(color: Color): String {
    return when (color) {
        Color.RED -> "This is a red color."
        Color.GREEN -> "This is a green color."
        Color.BLUE -> "This is a blue color."
    }
}

fun printColor(color: Color) {
    // Only valid Color values can be passed
    println("Selected color: $color")
}

enum class Direction(val degrees: Int) {
    NORTH(0),
    EAST(90),
    SOUTH(180),
    WEST(270);

    fun rotate(degrees: Int): Direction {
        val newDegrees = (this.degrees + degrees) % 360
        return values().first { it.degrees == newDegrees }
    }
}

//Sealed class

sealed class Tile
class Red(val type: String, val points: Int) : Tile()
class Blue(val points: Int) : Tile()


/*
*  an enum class is a special kind of class used to represent a fixed set of constants or values.
* Enum classes are useful when you have a predefined set of related values that should not change
* during the execution of the program.
*
* Sealed class is a special kind of class that represents a restricted hierarchy where each
* subclass must be declared in the same file as the sealed class itself.
* Sealed classes are useful for modeling restricted, closed sets of classes or data types.
* Sealed class benefit : When we define there is no need for else we have pre defined possibility Red and Blue.
* */