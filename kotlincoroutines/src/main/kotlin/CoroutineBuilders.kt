/*
------------------------------------------------- COROUTINE BUILDERS -------------------------------------------------
Coroutine builders are the functions using which we build a coroutine. In Kotlin there are three types of coroutine
builders namely launch, async and runBlocking.

1. launch     : This is "Fire and Forget" kind of coroutine builder. Which means it creates the new coroutine in the
                background and do not return any result to its caller. The launch expression returns a Job object on
                which we can invoke coroutine specific functions like cancel() and join(). The launch function can be
                called on GlobalScope as well.

2. async      : This coroutine builder creates a background coroutine and returns a result to its caller. It returns
                Deferred<T> object on which we can call await() suspending function to retrieve the value of deferred
                object which is returned i.e. to retrieve the returned value of the async function. The result of the
                last statement of async function will be the return value. The async function can be called on
                GlobalScope as well.

3. runBlocking: This coroutine builder creates a coroutine which blocks the thread in which it is running until its job
                is done. The runBlocking is mostly used to run tests on suspending functions. While running tests, we
                want to make sure not to finish the test while we are doing heavy work in test suspend functions. The
                runBlocking is not available for GlobalScope.

*/

import kotlinx.coroutines.*

fun main() {
    runBlocking {
        println("Run blocking coroutine started. Running on thread: ${Thread.currentThread().name}") // Main thread.


        val job: Job = launch {
            /* The launch will inherit the thread and scope of it's immediate parent coroutine. As runBlocking is
            running on main thread, the launch coroutine will run on main thread. */
            println("Launch coroutine started. Running on thread: ${Thread.currentThread().name}") // Main thread.

            delay(2000) // Fake background work.

            println("Launch coroutine ended. Running on thread: ${Thread.currentThread().name}") // Main or some other.
        }
        job.join() // Will wait for coroutine to finish its work only after which next statement will be executed.


        val num1 = 10
        val num2 = 20
        val deferredJob: Deferred<Int> = async {
            /* The async will inherit the thread and scope of it's immediate parent coroutine. As runBlocking is
            running on main thread, the launch coroutine will run on main thread. */
            println("Async coroutine started. Running on thread: ${Thread.currentThread().name}") // Main thread.

            delay(2000) // Fake background work.

            println("Async coroutine ended. Running on thread: ${Thread.currentThread().name}") // Main or some other.

            num1 + num2 // Total will be the return value.
        }
        /* await() function waits for coroutine completion and returns the result of coroutine i.e. result of the last
        line of it. Once coroutine finishes, next line will be executed. */
        val total: Int = deferredJob.await()
        println("$num1 + $num2 = $total")


        println("Run blocking coroutine ended. Running on thread: ${Thread.currentThread().name}") // Main thread.
    }
}