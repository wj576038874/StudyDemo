package com.joyrun.base.core

import kotlinx.coroutines.*

/**
 * author: wneJie
 * date: 2019-09-26 10:48
 * desc:
 */
fun main() = runBlocking<Unit> {
    // 在 runBlocking 作用域中启动一个新协程
    launch{
        println("world${Thread.currentThread().name}")
        launch (Dispatchers.IO){
            println("world2${Thread.currentThread().name}")
        }
    }
    launch(Dispatchers.Main){
//        aa()
        println("world3${Thread.currentThread().name}")
    }
    println("hello${Thread.currentThread().name}")
}

suspend fun aa(){
    delay(2000)
}