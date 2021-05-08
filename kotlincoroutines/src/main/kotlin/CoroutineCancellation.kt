/*
------------------------------------------------ COROUTINE CANCELLATION ------------------------------------------------
While programming there may come a situation where we might need to cancel the running coroutine for some reason. Such
as when the result of coroutine is no longer needed or coroutine is taking long time. To cancel a coroutine it must be
cooperative. There are two ways to make a coroutine cooperative. Either we can periodically invoke a suspending function
that checks for cancellation i.e. the suspending functions that belongs to "kotlinx.coroutines". Or explicitly check the
active status within the coroutine.

To cancel the coroutine Job.cancel() function is used in conjunction with Job.join(),  which means cancel the coroutine
if it is cooperative else wait for its completion. Job.cancelAndJoin() can be used instead Job.cancel() + Job.join().

When a coroutine containing a cancellable suspending function is cancelled it throws CancellationException. It is a good
practice to wrap the code inside try-catch block. In the finally block you cannot call suspending function as the
coroutine could be cancelled already. In order to call a suspending function in the finally block use the
withContext(NonCancellable) coroutine builder which creates a new coroutine in another context.

*/

import kotlinx.coroutines.*

fun main() = runBlocking {
    println("Main program starts.")


    val job1 = launch {
        try {
            for (i in 1..500) {
                delay(50) // Using function from kotlinx.coroutine package to make the coroutine cooperative.

                print("$i\t")
            }
        } catch (ex: CancellationException) {
            print("\nCoroutine cancelled.")
        } finally {
            print("\nFinally block called.")

            withContext(NonCancellable) {
                delay(50) // Calling suspending functions in finally block.
                print("\nCoroutine in finally block called.")
            }
        }
    }

    delay(2000)
    job1.cancel() // Will cancel the coroutine if it is cooperative.
    job1.join() // If coroutine cannot be cancelled it will wait for its completion.


    val job2 = launch(Dispatchers.Default) {
        println()
        for (i in 1..500) {
            /* Using CoroutineScope.isActive to check if the coroutine is active.
            Note: Requires Default Dispatcher. */
            if (!isActive) {
                return@launch
            }

            Thread.sleep(50) // Making loop wait for sometime for each iteration.
            print("$i\t")
        }
    }

    delay(2000)
    job2.cancelAndJoin() // Will cancel the coroutine if it is cooperative else will wait for its completion.


    println("\nMain program ends.")
}