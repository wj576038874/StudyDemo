package com.joyrun.base.lambda

/**
 * author: wneJie
 * date: 2019-09-29 15:59
 * desc:
 *
1. 无参数的情况 ：
val/var 变量名 = { 操作的代码 }

2. 有参数的情况
val/var 变量名 : (参数的类型，参数类型，...) -> 返回值类型 = {参数1，参数2，... -> 操作参数的代码 }

可等价于
// 此种写法：即表达式的返回值类型会根据操作的代码自推导出来。
val/var 变量名 = { 参数1 ： 类型，参数2 : 类型, ... -> 操作参数的代码 }

3. lambda表达式作为函数中的参数的时候，这里举一个例子：
fun test(a : Int, 参数名 : (参数1 ： 类型，参数2 : 类型, ... ) -> 表达式返回类型){
...
}
 */

val s1: () -> Unit = { println("lambda") }
//val s11 = { println("lambda") }

val s2: (x: Int) -> Int = { x -> x * 10 }

val s3 = { x: Int -> x * 10 }

fun main() {
    println(s1())
    println(s1.invoke())

    println(s2(20))
    println(s2.invoke(2))

    println(s3(3))
    println(s3.invoke(30))

    println(s2(1) == s3(1))
}