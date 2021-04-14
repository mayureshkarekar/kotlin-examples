/*
------------------------------------------------- EXTENSION FUNCTIONS -------------------------------------------------
Kotlin gives the programmer the ability to add more functionality to the existing classes, by without inheriting them.
This is achieved through a feature known as extensions. When a function is added to an existing class it is known as
Extension Function.

*/

import kotlin.math.pow

fun main() {
    val num1 = 20
    val square = num1.square()
    val power = num1.power(5)

    println("$num1^2 = $square")
    println("$num1^5 = $power")
}

fun Int.square() = this * this
fun Int.power(n: Int) = this.toDouble().pow(n.toDouble())