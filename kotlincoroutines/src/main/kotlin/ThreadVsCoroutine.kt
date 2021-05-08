/*
------------------------------------------------ THREADS VS COROUTINES ------------------------------------------------
Every process has threads in it for different tasks. For example, in an mobile application there is a Main/UI thread
which is responsible for interacting with user and performing basic operations like taking input from the user, showing
output on the UI, handling clicks, etc. But for the long running tasks like file download or database queries using main
thread is not a good idea. It may cause UI to freeze and the OS will show ANR (App Not Responding) pop-up. We create
background threads for such scenarios and run long running operations on it. But creating too many background threads
will consume more memory and at a point the device will go out of memory which may lead to app crash or misbehave. To
overcome this problem coroutines came to picture.

Like threads, coroutines can run in parallel, wait and communicate with each other. It's an optimized framework written
over the actual threading by taking advantage of the cooperative nature of functions to make it light and yet powerful.
So, we can say that Coroutines are lightweight threads. Coroutines runs within a thread and there can be multiple
coroutines in a thread. Coroutines are suspendable which means we can pause and resume them whenever we want to. They
can also switch to another thread from its current thread when required.

                   Threads                                               Coroutines
1. Threads are heavy.                                1. Coroutines are lightweight.
2. Process waits for thread to finish its work.      2. Process do not wait for coroutine to finish its work.
3. Threads are controlled by the OS.                 3. Coroutines are controlled by the user.

*/

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread

fun main() {
    println("Main started. Running on thread: ${Thread.currentThread().name}") // Main thread.


    thread { // Creates a background thread.
        println("Thread started. Running on thread: ${Thread.currentThread().name}") // Worker thread.
        Thread.sleep(3000) // Fake background work.
        println("Thread ended. Running on thread: ${Thread.currentThread().name}") // Worker thread.
    }


    GlobalScope.launch { // Creates a coroutine which runs on a background thread.
        println("Coroutine started. Running on thread: ${Thread.currentThread().name}") // Worker thread.

        /* Using delay() instead of Thread.sleep() to indicate fake work. Thread.sleep() blocks/sleeps the entire
        thread which will block all other coroutines as well in the current thread. The delay() function will suspend
        the current coroutine only and the current thread can continue its work.

        Note: delay() is a suspending function, means it can be used in coroutine or in another suspending function. */
        delay(3000) // Fake background work.

        // Coroutine may change its parent thread to another thread if required.
        println("Coroutine ended. Running on thread: ${Thread.currentThread().name}") // same/different Worker thread.
    }


    runBlocking { // Creates a coroutine which blocks the current thread until its completion.
        println("runBlocking coroutine started. Running on thread: ${Thread.currentThread().name}") // main thread.
        delay(3000) // Fake background work.
        println("runBlocking coroutine ended. Running on thread: ${Thread.currentThread().name}") // main thread.
    }


    /* By default the process does not wait for coroutines to finish its job. To make process wait calling
    Thread.sleep() to wait for two seconds so coroutine can finish the job. */
    Thread.sleep(5000)
    println("Main ended. Running on thread: ${Thread.currentThread().name}") // Main thread.
}