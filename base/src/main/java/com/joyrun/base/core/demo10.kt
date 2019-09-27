package com.joyrun.base.core

/**
 * author: wneJie
 * date: 2019-09-26 17:34
 * desc:
 */

//fun main() {
//
//    printSum { x, y ->
//        x + y
//    }
//
//    printSum2 { x, y, z ->
//
//    }
//
//}
//
//fun printSum(sum: (x: Int, y: Int) -> Int) {
//    val s = sum(1, 2)
//    println(s)
//}
//
//
//fun printSum2(sum2: (x: Int, y: Int, z: (s: Int) -> Int) -> Int) {
//
//    val r = sum2(1, 2,2)
//}
//
//val sum2 = {x:Int,y:Int,z:Int -> x+y}
//形参                                                                  //实参
val result: (x: Int, y: Int, z: (a: Int, b: Int) -> Int) -> Int =
    { x, y, z -> x + y + z.invoke(1, 2) }



val result2: (x: Int, y: Int) -> Int = { x, y -> x + y }

fun main() {
//    println(result2(10, 20))
//    println(result(10, 20){a,b ->
//        a+b
//    })

    val a = sumval(10,20) { a, b ->
        a+b
    }

    val b = {s:Int,b:Int -> s+b}

    println(a)

    fun1(1,2){s:Int,x:Int
        -> s+x
    }

    println(lambda.invoke(10,20))
    println(lambda(2, 3))
}


fun sum(x: Int, y: Int, z: (a: Int, b: Int) -> Int): Int = x+y+z.invoke(1,2)

val sumval = {x:Int,y:Int ,z : (a:Int,b:Int)->Int   ->   x+y+z.invoke(1,2)}

val lambda = {
        left: Int, right: Int
    ->
    left + right
}



fun fun1(x: Int, y: Int,z : (a:Int,b:Int)->Int): Int {
    return x + y+z.invoke(10,20)
}

fun fun1_1(x: Int, y: Int) = x + y

val fun1_2: (x: Int, y: Int) -> Int = { x, y -> x + y }

val fun1_3 = { x: Int, y: Int -> x + y }


//data class Person(
//    var name: String? = null,
//    var age: Int? = null,
//    var address: Address? = null
//)
//
//
//data class Address(
//    var street: String? = null,
//    var number: Int? = null,
//    var city: String? = null
//)
//
//fun person(p: (Person) -> Unit): Person {
//    return Person().apply { p(this) }
////    val p = Person()
////    p(p)
////    return p
//}
//
//fun person2(p: Person.() -> Unit) {
//    Person().apply {
//        p()
//    }
//}