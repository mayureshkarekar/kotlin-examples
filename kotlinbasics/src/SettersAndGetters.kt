/*
------------------------------------------------- SETTERS AND GETTERS -------------------------------------------------
There might be scenarios where we want to alter the way to set or get the value of the variable, for this reason setters
and getters are introduced. Setters are used to set the value and Getters are used to get the value of the variable. If
we do not create custom setters and getters Kotlin will provide default setters and getters which simply sets and gets
the value.

*/

fun main() {
    val thomas = Person()
    thomas.age = 5
    thomas.schoolName = "ABC School"
    println("Thomas's age is ${thomas.age} and his school name is ${thomas.schoolName}")

    val steve = Person()
    steve.age = -1
    steve.schoolName = "XYZ School"
    println("Steve's age is ${steve.age} and his school name is ${steve.schoolName}")
}

class Person {
    /* When the value for a variable is to be decided later then we can use lateinit to declare the variable. Which
    means the value for the variable will be set later. lateinit cannot be of primitive type and cannot be val. */
    lateinit var schoolName: String

    var age = 0
        // Defining a setter.
        set(value) {
            if (value >= 0) {
                field = value
                println("Inside setter of age.")
            } else {
                println("Age cannot be negative.")
            }
        }
        // Defining a getter.
        get() {
            println("Inside getter of age.")
            return field.toInt()
        }
}