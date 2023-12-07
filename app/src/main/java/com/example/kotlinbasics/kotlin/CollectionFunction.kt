package com.example.kotlinbasics.kotlin

/**
 * Created by Tirth Patel.
 */

fun main() {
    val num = listOf(1, 2, 3, 4, 5)
    println(isOdd(3))
    println(isOdd(2))

    num.forEach{ println(it) }  //Don't need to user for loop for this case

    //Different ways to write this

    val list = num.filter(::isOdd)
    println(list)

    val list2 = num.filter(fun(a: Int): Boolean {
        return a % 2 != 0
    })
    println(list2)

    val list3 = num.filter { it % 2 != 0 }
    println(list3)


    val userList = listOf(
        User("A", 1),
        User("B", 2),
        User("C", 3)
    )

    println(userList.filter { it.id == 2 })

    val list4 = num.map { it * it }
    println(list4)

    val paidUserList = userList.map {
        PaidUser(it.name, it.id, "Paid")
    }  // If we want to add or remove some parameter from list for new list
    println(paidUserList)


}

fun isOdd(a: Int): Boolean {
    return a % 2 != 0
}

data class User(val name: String, val id: Int)
data class PaidUser(val name: String, val id: Int, val type: String)

