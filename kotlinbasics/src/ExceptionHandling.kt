/*
-------------------------------------------------- EXCEPTION HANDLING --------------------------------------------------
Exception is a runtime problem which occurs in the program and leads to program termination. This may be occur due to
running out of memory space, array out of bond, condition like divided by zero. To handle this type of problem during
program execution the technique of exception handling is used. Exception handling is a technique which handles the
runtime problems and maintains the flow of program execution.

NOTE: In Java there are two types of exceptions, Checked Exceptions and Unchecked Exceptions. Kotlin does not supports
      Checked Exceptions.

*/

fun main() {
    val numberList = arrayOf(1, 2, 3)

    /* try block contains set of statements which might generate an exception. It must be followed by either catch or
    finally or both. */
    try {
        println("Inside try block.")
        println("Number on index 4 is ${numberList[4]}")
        println("Last statement of try block.")
    }
    /* catch block is used to catch the exception thrown from try block. There can me more than one catch blocks for
    handling different types of exceptions. */
    catch (e: Exception) {
        println("Inside catch block.")
    }
    /* finally block always execute whether exception is handled or not. So it is used to execute important code
    statement. */
    finally {
        println("Inside finally block.")
    }
}