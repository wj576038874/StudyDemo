package com.joyrun.base.lambda

/**
 * author: wneJie
 * date: 2019-09-29 17:57
 * desc:
 */

data class Person(
    var name: String? = null,
    var age: Int? = null,
    var address: Address? = null,
    var sayHello: ((String) -> Unit)? = null
)


class Address{
    var street: String? = null
    var number: Int? = null
    var city: String? = null
    var sayHello: ((String) -> Unit)? = null

    fun sayHello(sayHello: ((String) -> Unit)?){
        this.sayHello = sayHello
    }

}


fun person(block: Person.() -> Unit): Person {
    val person = Person()
    person.block()
    person.sayHello?.invoke("asd")
    return person
}

fun Person.address(block: Address.() -> Unit) {
//    val add = Address()
////    add.block()
////    block(add)
//    block.invoke(add)
//    add.sayHello?.invoke("11111")
//    address = add


    Address().apply {
        block()
        sayHello?.invoke("111111")
        address = this
    }
}


fun main() {
    val p = person {
        name = "小明"
        age = 19
        sayHello = {
            println("person$it")
        }

        address {
            city = "广州"
            number = 10
            street = "天河区"
            sayHello{
                println("address$it")
            }
        }

    }

    println(p.toString())

}