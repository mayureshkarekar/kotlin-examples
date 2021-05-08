/*
--------------------------------------------------- COROUTINE SCOPE ---------------------------------------------------
A CoroutineScope defines lifecycle, lifetime for the coroutines that are built and launched from it. A coroutine scope
lifecycle starts as soon as it is created and ends when it is canceled or when it associated Job or SupervisorJob
finishes. When that happens, the coroutine scope is no longer active. Every coroutine has its own coroutine scope
instance attached to it irrespective of parent.

*/

import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        println("runBlocking CoroutineScope: $this") // this refers to CoroutineScope instance.


        val parentLaunchCoroutine = launch {
            println("launch CoroutineScope: $this")

            // Child coroutine.
            launch {
                println("Child launch CoroutineScope: $this") // Will have different CoroutineScope than its parent.
            }
        }


        val parentAsyncCoroutine = async {
            println("async CoroutineScope: $this")

            // Child coroutine.
            async {
                println("Child async CoroutineScope: $this") // Will have different CoroutineScope than its parent.
            }
        }
    }
}