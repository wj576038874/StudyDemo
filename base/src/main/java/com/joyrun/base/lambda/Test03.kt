package com.joyrun.base.lambda

/**
 * author: wneJie
 * date: 2019-09-29 16:37
 * desc:
 */

fun main() {
    println(test(2,3))
    println(test_1(1,2))
    println(test_2(1,2))
    println(test_3(2,3))
}

fun test(x: Int, y: Int): Int {
    return x + y
}

fun test_1(x: Int, y: Int) = x + y

//形参模式
val test_2: (x: Int, y: Int) -> Int = { x, y -> x + y }

//实参模式
val test_3 = { x: Int, y: Int -> x + y }