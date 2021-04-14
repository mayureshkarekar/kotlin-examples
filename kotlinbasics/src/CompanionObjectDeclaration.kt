/*
--------------------------------------------- COMPANION OBJECT DECLARATION ---------------------------------------------
Companion objects are used to directly access the members of an object inside a class. The member can be accessed with
the class name followed by dot (".") operator and the member name. An object may or may not have a name. A class can
have only one companion object in it.

*/

import kotlin.math.pow

fun main() {
    val x = 50.0
    val y = 40.0

    /* Members of companion object can be called directly with it's class name followed by dot (".") operator and member
    name. */
    println("PI = ${Calculator.PI}")
    println("$x + $y = ${Calculator.add(x, y)}")
    println("$x - $y = ${Calculator.sub(x, y)}")
    println("$x * $y = ${Calculator.mul(x, y)}")
    println("$x / $y = ${Calculator.div(x, y)}")

    /* Objects inside a class can be accessed with its enclosing class name followed by dot (".") operator and the
    object name. */
    println("$x ^ $y = ${Calculator.Advanced.power(x, y)}")
}

class Calculator {
    // A class can have only one companion object.
    companion object {
        /* const is used where the value of an variable must be known at compile-time. const can be used for String and
        primitive data types and can be used for top-level declaration or in object. */
        const val PI = 3.14

        /* @JvmStatic annotation is used to make method accessible by class name followed by dot (".") operator and
        method name in a Java file. */
        @JvmStatic
        fun add(a: Double, b: Double) = a + b

        @JvmStatic
        fun sub(a: Double, b: Double) = a - b

        @JvmStatic
        fun mul(a: Double, b: Double) = a * b

        @JvmStatic
        fun div(a: Double, b: Double) = a / b
    }

    // A class can have multiple objects in it.
    object Advanced {
        fun power(a: Double, b: Double) = a.pow(b)
    }
}