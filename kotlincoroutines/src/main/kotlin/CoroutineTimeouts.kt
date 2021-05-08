/*
-------------------------------------------------- COROUTINE TIMEOUTS --------------------------------------------------
If coroutine is taking long time we might want to cancel it or we may need to perform time bounded task. Kotlin
introduces coroutine builders which creates which runs for specific time and throws exception or returns null if it
fails to finish the job within the given time. Kotlin allows us to create time bound coroutines using below coroutines
builders.

1. withTimeout      : Creates a coroutine in background that runs for time specified in the parameter. If it fails to
                      finish the job in specified time it throws the TimeoutCancellationException.

2. withTimeoutOrNull: Creates a coroutine in background that runs for time specified in the parameter and returns a
                      value to its caller. If it fails to finish the job in specified time it returns null.

*/

import kotlinx.coroutines.*

fun main() = runBlocking {
    println("Main program starts.")


    try {
        withTimeout(2000) {
            for (i in 1..500) {
                delay(500)
                print("$i\t")
            }

            println("Coroutine successfully finished before given time.")
        }
    } catch (e: TimeoutCancellationException) {
        print("\nCoroutine failed to perform task in given time.")
    } finally {
        print("\nFinally block called.")
    }


    println()
    val result: String? = withTimeoutOrNull(2000) {
        for (i in 1..500) {
            delay(500)
            print("$i\t")
        }

        "Coroutine successfully finished before given time."
    }
    println("\n${result ?: "Coroutine failed to perform task in given time."}")


    println("Main program ends.")
}