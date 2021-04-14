/*
------------------------------------------------------- IF-ELSE -------------------------------------------------------
If-else is used to check the condition and perform a certain action according to it. If accepts an condition in it, the
condition must return a boolean value. If the value is true, if block is executed, else block is executed if the return
value is false. In a if-else statement there can be multiple if blocks and the condition checking happens in sequence
they occur.

*/

fun main() {
    val marks = 59
    val grade = if (marks >= 75) {
        'A'
    } else if (marks in 60..74) { // If number lies between 60 to 74, i.e. 60, 61, 62, ...,73, 74.
        'B'
    } else if (marks in 35 until 60) { // If number lies between 35 to 59, i.e 35, 36, 37, ..., 58, 59.
        'C'
    } else {
        'F'
    }

    print("Grade is: $grade")
}