package com.joyrun.base.lambda

/**
 * author: wneJie
 * date: 2019-09-29 17:08
 * desc:
 */

fun main() {
    html {
        body()
    }

    val s = aa(1)
    println(s())
    println(s())
}

class Html {
    fun body() {
        println("body")
    }
}

fun html(init: Html.() -> Unit): Html {
    val html = Html()  // 创建接收者对象
//    init.invoke(html)       // 将该接收者对象传给该 lambda
    html.init()
    return html
//    return Html().apply {
//        init()
//    }
}

fun aa(b: Int): () -> Int {
    var a = 3
    return fun(): Int {
        a++
        return a + b
    }
}