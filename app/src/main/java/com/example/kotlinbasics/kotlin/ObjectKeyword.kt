package com.example.kotlinbasics.kotlin

/**
 * Created by Tirth Patel.
 */
object ObjectKeyword {
    val name: String = ""
    fun obj() {}
}

fun main() {

    //Object Expression
val classD = object : objf("juj"){
    override fun fullName() {
        super.fullName()
        println("Annomays - $name")
    }
}
    classD.fullName()
}

open class objf(val name: String){
    open fun fullName() = println("Full Name - $name")

}