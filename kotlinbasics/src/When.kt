/*
---------------------------------------------------- WHEN CONDITION ----------------------------------------------------
When expression is a conditional expression which returns the value. Kotlin, when expression is replacement of switch
statement. Kotlin, when expression works as a switch statement of other language (Java, C++, C). When condition accepts
a expression in it. According to the value of expression it executes the matching case. If any case does not match, it
executes else block.

*/

fun main() {
    val marks = 5
    val grade = when {
        marks >= 75 -> {
            'A'
        }
        marks in 60..74 -> {      // If number lies between 60 to 74, i.e. 60, 61, 62, ...,73, 74.
            'B'
        }
        marks in 35 until 60 -> { // If number lies between 35 to 59, i.e 35, 36, 37, ..., 58, 59.
            'C'
        }
        else -> {
            'F'
        }
    }

    println("Grade is: $grade")


    val animal = "Cat"
    when (animal) {
        "Dog" -> println("Animal is Dog.")
        "Cat" -> println("Animal is Cat.")
        "Cow" -> println("Animal is Cow.")
        else -> println("Animal not found.")
    }
}