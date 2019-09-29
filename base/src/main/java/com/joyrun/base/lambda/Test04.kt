package com.joyrun.base.lambda

/**
 * author: wneJie
 * date: 2019-09-29 16:46
 * desc:
 */

fun main() {
    println(sum(1, sum2(2, 3)))

    println(lambda {
        it * 20
    })

    println(lambda1 { x, y ->
        x + y
    })

    println(lambda2(2, 3) { x, y ->
        x + y
    })

    println(test(10) { it > 5 })
    println(test(4) { it > 5 })
}

fun sum(x: Int, y: Int): Int {
    return x + y
}

fun sum2(x: Int, y: Int): Int {
    return x + y
}

fun lambda(sum: (x: Int) -> Int): Int {

    return 2 * sum.invoke(10)
}

fun lambda1(y: (x: Int, y: Int) -> Int): Int {
    //通过函数变量调用自身
    return y.invoke(2, 3)
}

fun lambda2(mum1: Int, num2: Int, sum: (x: Int, y: Int) -> Int): Int {
    return sum.invoke(mum1, num2)
}

fun test(num1: Int, bool: (Int) -> Boolean): Int {
    return when (bool.invoke(num1)) {
        true -> num1
        else -> 0
    }
//    return if (bool(num1)) num1 else 0
}


