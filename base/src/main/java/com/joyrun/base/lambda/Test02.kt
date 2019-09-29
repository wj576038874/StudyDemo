package com.joyrun.base.lambda

/**
 * author: wneJie
 * date: 2019-09-29 16:34
 * desc:
 */

fun main(){
    test1()
    test2()
    test3()
}


fun test1(){
    println("无参数1")
}

fun test2() = println("无参数2")

val test3 = {
    println("无参数3")
}
