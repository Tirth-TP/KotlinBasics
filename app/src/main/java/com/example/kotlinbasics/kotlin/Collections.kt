package com.example.kotlinbasics.kotlin

/**
 * Created by Tirth Patel.
 */


fun main() {

    //List
    val nums = listOf(1, 2, 3)
    println(nums.indexOf(3))
    println(nums.contains(4))
//    nums[0] = 4  //This is immutable list you can't edit, add...

    val nums2 = mutableListOf(1, 2, 3)
    nums2[0] = 4
    nums2.add(8)
    nums2.remove(2)
    println(nums2)

    var list = listOf(11, 12)

    nums2.addAll(list)
    println(nums2)

    //Map
    val maplist = mutableMapOf<Int, String>()
    maplist.put(1, "First")
    maplist.put(2, "Second")
    maplist.put(3, "Third")
    maplist[4] = "four"

    println(maplist.get(1))
    println(maplist[3])
    println(maplist.get(10))

    for ((key, value) in maplist) {
        println("$key: $value")
    }

    //Map Immutable

    val mapListImmutable = mapOf<Int, String>(1 to "First", 2 to "Second")
    println(mapListImmutable)
}
