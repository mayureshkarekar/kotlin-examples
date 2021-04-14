/*
-------------------------------------------------------- LOOPS ---------------------------------------------------------
Looping is a feature which facilitates the execution of a set of instructions/functions repeatedly while some condition
evaluates to true. There are three types of loops in Kotlin namely for, while and do-while. The loop continues to
execute unless the specified condition meets. While iterating the loop "break" keyword is used to exit from it. To
immediately move to next iteration "continue" keyword is used.

*/

fun main() {
    var counter = 10

    // While Loop.
    println("---------- While Loop ----------")
    while (counter > 0) {
        println("Counter value is: ${counter--}")
    }


    // Do While Loop.
    counter = 10
    println("---------- Do While Loop ----------")
    do {
        println("Counter value is: ${counter--}")
    } while (counter > 0)


    // For Loop.
    counter = 10
    println("---------- For Loop ----------")
    for (i in 1..counter) {
        println("Counter value is: $i")
    }


    // For Loop With Step.
    counter = 10
    println("---------- For Loop With Step ----------")
    for (i in 1..counter step 2) { // Will increment i with 2.
        println("Counter value is: $i")
    }


    // For Loop With Decrement.
    counter = 10
    println("---------- For Loop With Decrement ----------")
    for (i in counter downTo 1) {
        println("Counter value is: $i")
    }


    // For Loop With Decrement And Step.
    counter = 10
    println("---------- For Loop With Decrement And Step ----------")
    for (i in counter downTo 1 step 2) { // Will decrement i with 2.
        println("Counter value is: $i")
    }


    // For Loop Using Array.
    val fruitsArray = arrayOf("Apple", "Orange", "Banana")
    for (fruit in fruitsArray) {
        println("Fruit name: $fruit")
    }


    // For Loop Using Array And Index.
    for ((index, fruit) in fruitsArray.withIndex()) {
        println("Fruit name on index $index: $fruit")
    }
}