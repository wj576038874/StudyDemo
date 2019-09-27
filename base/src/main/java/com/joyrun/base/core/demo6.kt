package com.joyrun.base.core

import kotlinx.coroutines.*

/**
 * author: wneJie
 * date: 2019-09-26 11:14
 * desc:
 */
fun main() = runBlocking {
//    val job = GlobalScope.launch {
//        repeat(1000){
//            println("job: I'm sleeping $it ...")
//            delay(500)
//        }
//    }
//    delay(1700)
//    println("main: I'm tired of waiting!")
//    job.cancel() // 取消该作业
//    job.join() // 等待作业执行结束
//    println("main: Now I can quit.")

    val startTime = System.currentTimeMillis()
    val job = launch(Dispatchers.Default) {
        var nextPrintTime = startTime
        var i = 0
        while (isActive) { // 一个执行计算的循环，只是为了占用 CPU
            // 每秒打印消息两次
            if (System.currentTimeMillis() >= nextPrintTime) {
                println("job: I'm sleeping ${i++} ...")
                nextPrintTime += 500L
            }
        }
    }
    delay(1300L) // 等待一段时间
    println("main: I'm tired of waiting!")
    job.cancelAndJoin() // 取消一个作业并且等待它结束
    println("main: Now I can quit.")
}