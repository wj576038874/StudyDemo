package com.joyrun.base.core

import kotlinx.coroutines.*

/**
 * author: wneJie
 * date: 2019-09-26 10:37
 * desc:
 */
fun main() = runBlocking {
    val job = GlobalScope.launch {
        delay(10000)
        println("world${Thread.currentThread().name}")
    }
    println("hello${Thread.currentThread().name}")
    job.join()// 等待直到子协程执行结束  这句话不加打印不出来world 因为主线程已经结束了 协程也会结束
}