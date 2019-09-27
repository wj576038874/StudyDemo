package com.joyrun.base.core

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import okhttp3.internal.threadName

/**
 * author: wneJie
 * date: 2019-09-26 10:53
 * desc:
 */

fun main() = runBlocking {
    launch {
        delay(2000)
        println("Task from runBlocking---${Thread.currentThread().name}")
    }

    coroutineScope {
        launch {
            delay(500)
            println("Task from nested launch---${Thread.currentThread().name}")
        }

        delay(100)
        println("Task from coroutine scope---${Thread.currentThread().name}") // 这一行会在内嵌 launch 之前输出
    }
    println("Coroutine scope is over---${Thread.currentThread().name}") // 这一行在内嵌 launch 执行完毕后才输出
}