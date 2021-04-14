/*
------------------------------------------------ DATA CLASS DECLARATION ------------------------------------------------
Data classes are used to define the POJOs in Kotlin i.e. the class which hold data. In data class basic functionality is
by default derived i.e. basic functions like toString(), hashCode() and equals() are by default overridden. The primary
constructor of data class must have one parameter at least (and must be marked as val or var). Data classes cannot be
abstract, open, sealed or inner.

*/

fun main() {
    val ramesh = Student(1001, "Ramesh", "Thane")
    val suresh = Student(1002, "Suresh", "Mumbai")

    // Data classes by default overrides toString(), hashCode() and equals() method of Any class.
    println(ramesh)
    println(suresh)


    // Checks if both objects has same data/content. == calls equals() behind the scenes.
    if (ramesh == suresh) {
        println("Both are same.")
    } else {
        println("Both are different.")
    }


    // Copying the content of object and changing the necessary ones.
    val mahesh = ramesh.copy(rollNo = 1003, name = "Mahesh")
    println(mahesh)


    // Destructuring: Creating the variables by coping values of object.
    val (rollNo, name) = ramesh
    println("Roll no.: $rollNo")
    println("Name: $name")
}

data class Student(val rollNo: Int, val name: String, val city: String)