/*
-------------------------------------------------- COROUTINE CONTEXT --------------------------------------------------
Similar to CoroutineScope every coroutine has its own CoroutineContext and unlike CoroutineScope the CoroutineContext
can be inherited from its parent. The coroutine context is a set of various elements. The main elements are the Job of
the coroutine and its dispatcher. The Job represents the coroutine itself and Dispatcher determines the thread of the
coroutine.

Dispatcher: The coroutine context includes a coroutine dispatcher that determines what thread or threads the
corresponding coroutine uses for its execution. The coroutine dispatcher can confine coroutine execution to a specific
thread, dispatch it to a thread pool, or let it run unconfined. A coroutine can have following types of Dispatcher.

1. Confined  : When a coroutine builder such as launch/async is called without any parameter it creates a coroutine with
               a confined dispatcher. The coroutine inherits the context of its immediate parent coroutine. The
               coroutine stays confined to its thread. Which means after suspension it will not change its thread.

2. Unconfined: This kind of coroutines are not confined to any specific thread. Dispatchers.Unconfined is passed in the
               parameter of launch/async coroutine builder to create a unconfined coroutine. It executes immediately in
               the current thread, but only until the first suspension point. After suspension it resumes the coroutine
               in the thread that is fully determined by the suspending function that was invoked.

3. Default   : This type of coroutines are exactly similar to GlobalScope.launch/async() coroutine. Hence it will create
               a coroutine at application level and will run on a separate background thread. After the suspension the
               coroutine will continue running on same or some other thread.

4. Main      : This dispatcher starts the coroutine in the main thread and remains confined to it. Usually such
               dispatchers are single-threaded. It is mostly used when we need to perform the UI operations within the
               coroutine.

5. IO        : The CoroutineDispatcher that is designed for offloading blocking IO tasks to a shared pool of threads. It
               starts the coroutine in the IO thread, such type of coroutines are used to perform all the data
               operations such as networking, reading, or writing from the database, reading, or writing to the files.

Apart from specifying the dispatcher explicitly we can pass CoroutineContext in the parameter depending on which the
coroutine will select its thread. Such coroutines are confined i.e. sticks to one thread only.

*/

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        println("Main program started: Running on thread: ${Thread.currentThread().name}")


        // Creating coroutine with confined dispatcher.
        launch {
            // Main thread.
            println("Confined dispatcher coroutine: Running on thread: ${Thread.currentThread().name}")

            delay(1000)

            // Main thread.
            println("Confined dispatcher coroutine after delay: Running on thread: ${Thread.currentThread().name}")
        }


        // Creating coroutine with unconfined dispatcher.
        launch(Dispatchers.Unconfined) {
            // Main thread.
            println("Unconfined dispatcher coroutine: Running on thread: ${Thread.currentThread().name}")

            delay(1000)

            // Some other thread.
            println("Unconfined dispatcher coroutine after delay: Running on thread: ${Thread.currentThread().name}")

            // Child coroutine.
            launch {
                // Will run on the thread above println is running.
                println("Child confined dispatcher coroutine of unconfined: Running on thread: ${Thread.currentThread().name}")
            }
        }


        // Creating coroutine with default dispatcher. Behave same like GlobalScope.launch {}.
        launch(Dispatchers.Default) {
            // App level worker thread.
            println("Default dispatcher coroutine: Running on thread: ${Thread.currentThread().name}")

            delay(1000)

            // Same or some other thread.
            println("Default dispatcher coroutine after delay: Running on thread: ${Thread.currentThread().name}")
        }


        // Creating coroutine with main dispatcher. This is Android specific and can be used in Android project only.
        /*launch(Dispatchers.Main) {
            println("Main dispatcher coroutine: Running on thread: ${Thread.currentThread().name}")
            delay(1000)
            println("Main dispatcher coroutine after delay: Running on thread: ${Thread.currentThread().name}")
        }*/


        // Creating coroutine with IO dispatcher.
        launch(Dispatchers.IO) {
            // IO thread.
            println("IO dispatcher coroutine: Running on thread: ${Thread.currentThread().name}")

            delay(1000)

            // Same or some other thread.
            println("IO dispatcher coroutine after delay: Running on thread: ${Thread.currentThread().name}")
        }


        /* Creating coroutine using CoroutineContext. coroutineContext represents CoroutineContext reference of the
        coroutine. */
        launch(coroutineContext) {
            println("Coroutine using coroutine context: Running on thread: ${Thread.currentThread().name}")
        }


        delay(3000)
        println("Main program ended: Running on thread: ${Thread.currentThread().name}")
    }
}