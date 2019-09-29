package com.joyrun.base

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        GlobalScope.launch {
            println("thread1 - ${Thread.currentThread().name}")
            launch(Dispatchers.Default) {
                println("thread3 - ${Thread.currentThread().name}")
            }
        }
        println("thread2 - ${Thread.currentThread().name}")
        Thread.sleep(2000)
    }
}
