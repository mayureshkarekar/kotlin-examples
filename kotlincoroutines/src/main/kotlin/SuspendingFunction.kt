/*
------------------------------------------------- SUSPENDING FUNCTION -------------------------------------------------
The function with "suspend" modifier is known as suspending function. Suspending functions are like normal functions
except the system has the ability to pause its execution and continue it later on. Suspending function can be called
from a coroutine or from another suspend function.

*/

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main() {
    GlobalScope.launch {
        doBackgroundWork() // Suspending function call in a coroutine.
    }

    Thread.sleep(6000) // Forcing the process to wait the coroutine to finish its job.
}

suspend fun doBackgroundWork() {
    println("Suspending function doBackgroundWork started.")

    for (i in 1..10) {
        // Indicating a fake background work.
        println("Process completed: ${i * 10}%")
        waitForMillis(500) // Suspending function calling another suspending function.
    }

    println("Suspending function doBackgroundWork ended.")
}

suspend fun waitForMillis(millis: Long) = delay(millis)