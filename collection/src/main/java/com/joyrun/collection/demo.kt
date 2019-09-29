package com.joyrun.collection

/**
 * author: wneJie
 * date: 2019-09-29 15:12
 * desc:
 */


fun main() {
    print1{ x, y ->
        x * y
    }
    //
}


fun print1(sum: (x: Int, y: Int) -> Int) {
    val s = sum(1, 2)
    println(s)
}