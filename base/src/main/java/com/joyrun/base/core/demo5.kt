package com.joyrun.base.core

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * author: wneJie
 * date: 2019-09-26 11:00
 * desc:
 */

fun main() = runBlocking {
//    repeat(100000){
//        launch {
//            delay(1000)
//            print("${it+1},")
//        }
//    }

    GlobalScope.launch {
        repeat(1000){
            println("I'm sleeping $it ...")
            delay(500)
        }
    }
    delay(1300)
}

// 这是你的第一个挂起函数
suspend fun doWorld(){
    delay(1000L)
    println("World!")
}