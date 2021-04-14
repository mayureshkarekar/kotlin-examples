/*
--------------------------------------------------- INLINE FUNCTIONS ---------------------------------------------------
In Kotlin, the higher-order functions or lambda expressions, all stored as an object so memory allocation, for both
function objects and classes, and virtual calls might introduce runtime overhead. Sometimes we can eliminate the memory
overhead by inlining the lambda expression. In order to reduce the memory overhead of such higher-order functions or
lambda expressions, we can use the "inline" keyword which ultimately requests the compiler to not allocate memory and
simply copy the inlined code of that function at the calling place.

*/

fun main() {
    calculateTimeTakenNoInline { loopTillN(1000000) }
    calculateTimeTaken { loopTillN(1000000) }
}

fun loopTillN(n: Long) {
    for (i in 1..n) {
    }
}

fun calculateTimeTakenNoInline(fn: () -> Unit) {
    val startTime = System.currentTimeMillis()
    fn()
    val endTime = System.currentTimeMillis()

    println("Time taken to execute: ${endTime - startTime}ms")
}

inline fun calculateTimeTaken(fn: () -> Unit) {
    val startTime = System.currentTimeMillis()
    fn()
    val endTime = System.currentTimeMillis()

    println("Time taken to execute: ${endTime - startTime}ms")
}