package com.joyrun.base.core

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * author: wneJie
 * date: 2019-09-26 10:48
 * desc:
 */
fun main() = runBlocking<Unit> {
    // 在 runBlocking 作用域中启动一个新协程
    launch{
        delay(3000)
        println("world${Thread.currentThread().name}")
    }
    println("hello${Thread.currentThread().name}")
}