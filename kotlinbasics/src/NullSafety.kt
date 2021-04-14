/*
----------------------------------------------------- NULL SAFETY -----------------------------------------------------
While programming there may come a situation where we don't know the value for a variable. In this case we define that
variable as a nullable variable and assign it a value when right time comes. To define a nullable variable we need to
append a question mark (?) after the datatype of the variable. But if we invoke any method on a null object it will
throw the NullPointerException. To avoid this situation we need to check if the object is non-null using if condition.
To simplify null checking Kotlin has introduced below features.

1. Null-Check Operator       : Question mark (?) is used to check if object is non-null. If the object is non-null then
                               only it will invoke the expression.
2. Requires-Non-Null Operator: Double exclamation (!!) is used as requires non-null operator. If the object is null then
                               it throws the exception.

*/

fun main() {
    // Question marks must be appended to datatype to declare the variable as nullable.
    val message: String? = null

    // Safe Method Invocation: Question mark is used to invoke the method on a object only when the object ii non-null.
    val messageInUppercase = message?.toUpperCase()
    println(messageInUppercase)

    /* Null-safe execution using let expression. The statement inside let will execute only if message is non-null as we
    used null check operator. */
    message?.let {
        println("Message is $it")
    }

    /* Elvis Operator: Elvis operator is like else block, it will execute the statement after it if expression before it
    is null. */
    val nonNullMessage = message ?: "No message."
    println(nonNullMessage)
}