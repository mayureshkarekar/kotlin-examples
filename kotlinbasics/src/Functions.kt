/*
------------------------------------------------------ FUNCTIONS ------------------------------------------------------
A function is a block of code which only runs when it is called. You can pass data, known as parameters, into a method.
Functions are used to perform certain actions, and they are also known as methods. The functions can be parameterized or
parameterless. The function parameters are of val type i.e. they cannot be modified. The function may return a value to
its calling function.

*/

fun main() {
    val x = 10
    val y = 5

    printHello()
    println("$x + $y = ${add(x, y)}")
    println("$x - $y = ${sub(a = x, b = y)}") // Specifying the parameter name.
    println("$x * 2 = ${mul(b = x)}")         // Forcing to use default value for parameter a.


    // Assigning a function to a variable.
    val funAdd = ::add
    println("5 + 4 = ${funAdd(5, 4)}")

    // Assigning a function to a variable and specifying object type explicitly.
    val funSub: (x: Int, y: Int) -> Int = ::sub
    println("5 - 4 = ${funSub(5, 4)}")

    // Calling function accepting vararg.
    val summation = summation(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    println("Summation of 1 to 10 is $summation")
}

// Standard function.
fun printHello() {
    println("Hello")
}

// Standard function.
fun add(a: Int, b: Int): Int { // Note: Parameters in a functions are of val type, i.e. their value cannot be changed.
    return a + b
}

// Inline function with specifying return type explicitly.
fun sub(a: Int, b: Int): Int = a - b

// Inline function without specifying return type.
fun mul(a: Int = 2, b: Int) = a * b  // Default value for parameter a if we don't pass value for it.

// Function accepting undefined number of integer arguments.
fun summation(vararg values: Int): Int {
    var summation = 0

    for (value in values) {
        summation += value
    }

    return summation
}