package com.joyrun.base.core

/**
 * author: wneJie
 * date: 2019-09-27 14:05
 * desc:
 */
class Person {


    var add: (x: Int, y: Int) -> Int = { x: Int, y: Int ->

        x + y

    }


}

fun Int.printlen(){
    println(this.toString())
}


fun main(){

    val person = Person()
    person.add(10,20).printlen()

}