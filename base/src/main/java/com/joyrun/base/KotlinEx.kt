package com.joyrun.base

import android.text.TextUtils
import android.util.Log
import kotlinx.coroutines.*
import retrofit2.HttpException
import java.net.ConnectException
import java.net.SocketTimeoutException
import kotlin.concurrent.thread

/**
 * author: wneJie
 * date: 2019-09-26 09:32
 * desc:
 */


fun log(msg: String) {
    Log.e("asd", msg)
}

val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
    val msg: String = when (throwable) {
        is HttpException -> {
            when (throwable.code()) {
                400 -> "手机号或验证码错误"
                401 ->
                    //启动登录页面
                    "token失效,请重新登录"
                else -> "请求出错了，错误代码" + throwable.code()
            }
        }
        is SocketTimeoutException -> "请求超时。请稍后重试！"
        is ConnectException -> "请求超时。请稍后重试！"
        else -> "请求出错了。请稍后重试！"
    }
    log("Throws an exception with message: ${msg}")
}

fun main() {
    // 在后台启动一个新的协程并继续
    //协程的生命周期只受整个应用程序的生命周期限制
//    GlobalScope.launch {
//        // 非阻塞的等待 1 秒钟（默认时间单位是毫秒）
//        delay(1000)
//        println("world${Thread.currentThread().name}")
//    }
//    Thread.sleep(2000)// 阻塞主线程 2 秒钟来保证 JVM 存活
//    for (i in 1..10) {
//        println("hello$i+${Thread.currentThread().name}")// 协程已在等待时主线程还在继续
//    }


    GlobalScope.launch {
        delay(1000)
        println("world${Thread.currentThread().name}")
    }
    println("hello${Thread.currentThread().name}")
    runBlocking {
        delay(2000)
    }
    println("kotlin${Thread.currentThread().name}")
}
