package com.joyrun.base.core

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

/**
 * author: wneJie
 * date: 2019-09-26 11:29
 * desc:
 */

fun main() = runBlocking {
    val time = measureTimeMillis {
        val one = async { doSomethingUsefulOne() }
        val two = async { doSomethingUsefulTwo() }
        println("The answer is ${one.await() + two.await()}")
    }
    println("Completed in $time ms")

    val c = CoroutineScope(coroutineContext)

}

suspend fun doSomethingUsefulOne(): Int {
    delay(1000)
    return 13
}

suspend fun doSomethingUsefulTwo(): Int {
    delay(1000)
    return 29
}