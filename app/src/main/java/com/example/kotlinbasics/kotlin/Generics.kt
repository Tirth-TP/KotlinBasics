package com.example.kotlinbasics.kotlin

/**
 * Created by Tirth Patel.
 */
fun main() {

    var obj = IntContainer(3)
    obj.getValue()

    var iContainer = Container<Int>(3)
    //We can pass type after function name or it will auto detect based on value we are passing
    iContainer.getValue()

    var iContainer2 = Container("Hello")
    iContainer2.getValue()
}

// Here are two functions which are used for same purpose just different data type
// If we want this function for Double then we need to make new function instead of making new function
// we can use Generic functions

class IntContainer(var data: Int) {
    fun setValue(value: Int) {
        data = value
    }

    fun getValue(): Int {
        return data
    }
}

class StringContainer(var data: String) {
    fun setValue(value: String) {
        data = value
    }

    fun getValue(): String {
        return data
    }
}

//Lets create Generic functions for the same
//T is for Type we can use anything A,B,C,D...
class Container<T>(var data: T) {
    fun setValue(value: T) {
        data = value
    }

    fun getValue(): T {
        return data
    }
}