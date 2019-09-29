package com.joyrun.base.core

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Environment
import com.joyrun.base.coroutine.log
import kotlinx.coroutines.*
import java.io.File
import kotlinx.coroutines.Dispatchers

/**
 * author: wneJie
 * date: 2019-09-26 10:33
 * desc:
 */

fun main(){
    GlobalScope.launch() {
        println("thread1 - ${Thread.currentThread().name}")
        launch(Dispatchers.Main) {
            println("thread3 - ${Thread.currentThread().name}")
        }
    }
    println("thread2 - ${Thread.currentThread().name}")
    Thread.sleep(2000)
}




