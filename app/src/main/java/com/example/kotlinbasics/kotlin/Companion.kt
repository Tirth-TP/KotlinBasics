package com.example.kotlinbasics.kotlin

/**
 * Created by Tirth Patel.
 */

fun main() {
//    MyClass.MyObject.f()  //Before companion object
    MyClass.f()     //After companion object
    MyClass.MyObject2.f2()
    val p = MyClass()
    val p2 = MyClass.f()


    //Example

    val pizza1 = Pizza.create("Tomato")
    println(pizza1)  //Default behind it is calling toString() method So we override toString() and print data there

}

//Only One Companion object allowed per class

class MyClass {
    companion object MyObject {
        //        @JvmStatic     //It will work as a static method with MyClass in java code Not needed for kotlin
        fun f() {
            println("Hello I ma F from Object!")
        }
    }

    object MyObject2 {
        fun f2() {
            println("Hello I ma F2 from Object!")
        }
    }
}


// No one can call Pizza class directly If some want pizza then they need to
// call create() so we are making Pizza constructor private
// So Pizza class can be accessible but for access methods inside class

class Pizza private constructor(val type: String, val toppings: String) {
    companion object Factory {
        fun create(pizzaType: String): Pizza {
            return when (pizzaType) {
                "Tomato" -> Pizza("Tomato", "Tomato,Cheese")
                "Paneer" -> Pizza("Paneer", "Paneer,Cheese Burst,Onion")
                else -> Pizza("Basic", "Onion,Cheese")
            }
        }
    }

    override fun toString(): String {
        return "Pizza(type='$type', toppings='$toppings')"
    }
}
