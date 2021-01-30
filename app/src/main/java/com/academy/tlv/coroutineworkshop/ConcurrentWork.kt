package com.academy.tlv.coroutineworkshop

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.launch
import java.util.concurrent.Executors

/**
 * Exercise
 * After lecture we need know that Coroutines this is try to be Cooperative(if we will help with it), Concurrent
 * Run main function
 * You can see that work in this section do sequentially
 * With your knowledge in coroutines try to fix the code so, that coroutines will do concurrent work without
 * adding the new Dispatcher to the launch
 */
fun main() {

    //do not change scope dispatcher
    val dispatcher = Executors.newSingleThreadExecutor().asCoroutineDispatcher()
    val scope = CoroutineScope(dispatcher)

    scope.launch {
        println("launch:[1], timeStamp:[${System.currentTimeMillis()}], thread:[${Thread.currentThread().id}]")
        doSomeWork(1)
    }

    scope.launch {
        println("launch:[2], timeStamp:[${System.currentTimeMillis()}], thread:[${Thread.currentThread().id}]")
        doSomeWork(2)
    }
}

private fun doSomeWork(num: Int) {
    Thread.sleep(2000)  //todo switch to delay suspend fun, why? ask mentor if it not clear for you
    println("do some work delay [$num], timeStamp:[${System.currentTimeMillis()}], thread:[${Thread.currentThread().id}] done")
}
