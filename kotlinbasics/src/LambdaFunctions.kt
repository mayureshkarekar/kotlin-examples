/*
--------------------------------------------------- LAMBDA FUNCTIONS ---------------------------------------------------
Lambda is a function which has no name i.e. anonymous function. Lambda is defined with a curly braces {} which may takes
variable as a parameter and body of function. The body of function is written after variable (if any) followed by "->"
operator. The last line in lambda defines the return type of the lambda.

*/

fun main() {
    val num1 = 50
    val num2 = 20

    // Defining parameterised lambda.
    val additionLambda = { x: Int, y: Int -> x + y }

    // Defining parameterless lambda.
    val msgLambda = {
        println("Hello there...")
        println("Have a good day...") // Last line will be the return value/type.
    }

    // Calling lambda functions.
    println("$num1 + $num2 = ${additionLambda(num1, num2)}")
    msgLambda()

    // Lambdas with single parameter can use "it" to refer the parameter.
    val squareLambda: (Int) -> Int = { it * it }
    println("Square of $num1 is ${squareLambda(num1)}")

    // Lambda with matching type can be passed to higher order functions.
    calculate(num1, num2, additionLambda) // Passing lambda variable as a parameter.
    calculate(num1, num2, { x: Int, y: Int -> x - y }) // Passing lambda expression as parameter.
    calculate(num1, num2, { x, y -> x * y }) // Passing lambda expression as parameter without its parameters datatype.
    calculate(num1, num2) { x, y -> x / y } // Passing lambda expression out of parenthesis.
}