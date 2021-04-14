/*
----------------------------------------------------- COLLECTIONS -----------------------------------------------------
A collection usually contains a group of objects of the same type. Objects in a  collection are called elements or
items. For example, all the students in a department form a collection that can be used to calculate their average age.

1. List: List is an ordered collection with access to elements by indices – integer numbers that reflect their position.
         Elements can occur more than once in a list. An example of a list is a sentence: it's a group of words, their
         order is important, and they can repeat. List can be mutable or immutable. Mutable lists can be modified i.e.
         we can add, modify and remove its elements. Immutable lists cannot be modified.

2. Map : Map (or dictionary) is a set of key-value pairs. Keys are unique, and each of them maps to exactly one value.
         The values can be duplicates. Maps are useful for storing logical connections between objects, for example, an
         employee's ID and their position. Map can be mutable or immutable. Mutable maps can be modified i.e. we can
         add, modify and remove its elements. Immutable maps cannot be modified.

3. Set : Set is a collection of unique elements. It reflects the mathematical abstraction of set: a group of objects
         without repetitions. Generally, the order of set elements has no significance. For example, an alphabet is a
         set of letters.

*/

fun main() {
    // Declaring an immutable list.
    val immutableStudentList = listOf("Jack", "Steve", "Morry")
    println("Student at index 1 in immutable list: ${immutableStudentList[1]}") // Accessing an element.

    // Declaring a mutable list.
    val mutableStudentList = mutableListOf("Harry", "Bill", "Kenny")
    println("Student at index 0 in mutable list: ${mutableStudentList[0]}") // Accessing an element.
    mutableStudentList.add("Robert") // Adding a new element.
    mutableStudentList[2] = "Morris" // Modifying an element.

    // Loops using List.
    for (student in immutableStudentList) {
        println("Student in immutable list: $student")
    }

    // Loops using List with index.
    for ((index, student) in mutableStudentList.withIndex()) {
        println("Student on index $index in mutable list: $student")
    }


    // Declaring an immutable map.
    val immutableStudentMap = mapOf<Int, String>(101 to "Tom", 102 to "Kris", 103 to "Elon", 105 to "Jhon")
    println("Student for key 101 in immutable map: ${immutableStudentMap[101]}") // Accessing an element.

    // Declaring an mutable map.
    val mutableMap = mutableMapOf<Int, String>()
    mutableMap[101] = "Bob" // Adding a new element.
    mutableMap[102] = "Stuart" // Adding a new element.
    mutableMap[103] = "Oliver" // Adding a new element.
    mutableMap[102] = "Yuri" // Modifying an element.

    // Loop using map.
    for (student in mutableMap) {
        println("Student in mutable map: $student")
    }

    // Loop using map with index.
    for ((rollNo, student) in mutableMap) {
        println("Student in mutable map for roll no. $rollNo: $student")
    }


    // Declaring an immutable set.
    val immutableStudentSet = setOf("Dominic", "Messi", "Kelvin", "Peter")

    // Declaring a mutable set.
    val mutableStudentSet = mutableSetOf("Tony", "Gorden", "Thomas", "James")
    mutableStudentSet.add("Bruce") // Adding a new element.

    // Loop using set.
    for (student in mutableStudentSet) {
        println("Student in mutable set: $student")
    }

    // Loop using set with index.
    for ((index, student) in mutableStudentSet.withIndex()) {
        println("Student on index $index in mutable set: $student")
    }
}