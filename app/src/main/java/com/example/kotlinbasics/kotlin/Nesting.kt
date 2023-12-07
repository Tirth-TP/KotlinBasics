package com.example.kotlinbasics.kotlin

/**
 * Created by Tirth Patel.
 */
fun main() {
    val obj = Outer()  //Simple object for class
    obj.i

    val nestedObj = Outer.Nested()  //Nested class object
    nestedObj.test()

    // (We can not access nested class like this if we make nested class inner class)

    val nestedObj2 = Outer().Nested2()
    nestedObj2.test()

    //We have to create Outer class object then nested class object coz we are using outer class properties
    // so we need to make outer class object

}

class Outer {
    val i = 0

    class Nested {      //This is nested class here we cannot access outer class properties and functions
        fun test() {
            println("I am in Nested class")   //I can't use i here
        }
    }

    //If we want to use outer class properties then we need to make class inner here is e.x
    inner class Nested2 {
        fun test() {
            println("I am in Nested class $i")
        }
    }
}