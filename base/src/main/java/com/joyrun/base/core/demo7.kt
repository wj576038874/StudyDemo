package com.joyrun.base.core

import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * author: wneJie
 * date: 2019-09-26 11:23
 * desc:
 */

fun main() = runBlocking {
    val job = launch {
        try {
            repeat(1000){
                println("job: I'm sleeping $it ...")
                delay(500L)
            }

        }catch (e:Exception){
            e.printStackTrace()
        }finally {
            println("job: I'm running finally")
        }
    }
    delay(1300L) // 延迟一段时间
    println("main: I'm tired of waiting!")
    job.cancelAndJoin() // 取消该作业并且等待它结束
    println("main: Now I can quit.")
}