package com.joyrun.base.core

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * author: wneJie
 * date: 2019-09-26 10:33
 * desc:
 */

//fun main(){
//    GlobalScope.launch {
//        delay(1000)
//        println("world${Thread.currentThread().name}")
//    }
//    println("hello${Thread.currentThread().name}")
//    runBlocking {
//        delay(2000)
//    }
//    println("kotlin${Thread.currentThread().name}")
//}

fun main() = runBlocking {
    GlobalScope.launch {
        delay(1000)
        println("world${Thread.currentThread().name}")
    }
    println("hello${Thread.currentThread().name}")
    delay(2000)
}