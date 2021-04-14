/*
------------------------------------------------ HIGHER ORDER FUNCTIONS ------------------------------------------------
A function which can accepts a function as parameter or can returns a function is called Higher-Order function. Instead
of Integer, String or Array as a parameter to function, we will pass anonymous function or lambdas. Frequently, lambdas
are passed as parameter in Kotlin functions for the convenience.

*/

fun main() {
    val num1 = 100
    val num2 = 50
    val addFunction = ::add // Creating variable to hold function.

    calculate(num1, num2, addFunction) // Passing function as parameter.
    calculate(num1, num2, ::sub) // Passing function as parameter.
}

fun calculate(x: Int, y: Int, operation: (Int, Int) -> Int) {
    println("Calculation is : ${operation(x, y)}") // Invoking the passed function.
}