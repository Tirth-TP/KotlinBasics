package com.example.kotlinbasics.kotlin

/**
 * Created by Tirth Patel.
 */
fun main() {
    val emp = Employee()
    emp.name = "A"
    emp.age = 20

    //apply (Default return type is same as object type here it is Employee)

    emp.apply {
        name = "B"
        age = 52
    }
    println(emp)


    //let  (If we want to perform multiple operations on one object this is useful)
    //Default return type will be same as last expression type here it is Unit check by assign this in variable
    var x = emp.let {
        println(it.name)
        println(it.age)
    }

    val empLet: Employee? = null
    empLet?.name = "A"
    empLet?.age = 20   //We have to check nullable everytime instead we can use let

    empLet?.let {
        it.name = "B"
        it.age = 22
    }

    //For this we can use with as well (return type is according to last expression)
    val empWith: Employee = Employee()

    with(empWith) {
        name = "test"
        age = 22
    }

    // We can use run as well (return type is according to last expression same as let and run)
    //run is a combination of let and run

    val t = empWith.run {
        name = "test"
        age = 22
    }

}

data class Employee(var name: String = "", var age: Int = 18)