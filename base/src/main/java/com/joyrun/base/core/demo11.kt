package com.joyrun.base.core

import kotlinx.coroutines.*
import java.lang.Exception

/**
 * author: wneJie
 * date: 2019-09-29 10:30
 * desc:
 */

fun main() = runBlocking<Unit> {
    try {
        println(failedConcurrentSum())
    } catch(e: ArithmeticException) {
        println("Computation failed with ArithmeticException")
    }
}

suspend fun failedConcurrentSum(): Int = supervisorScope {
    val one = async {
        try {
            delay(5000) // 模拟一个长时间的运算
            42
        }
        finally {
            println("First child was cancelled")
        }
    }
    val two = async<Int> {
        println("Second child throws an exception")
        throw ArithmeticException()
    }
    one.await() + two.await()
}