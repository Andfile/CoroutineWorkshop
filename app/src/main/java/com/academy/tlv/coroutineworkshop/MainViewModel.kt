package com.academy.tlv.coroutineworkshop

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

private const val TAG = "MainViewModel"

class MainViewModel(private val imageRepo: ImagesRepo = ImagesRepoImpl()) : ViewModel() {

    //change the coroutine scope by view model scope
    private val coroutineScope = CoroutineScope(Dispatchers.Default)
    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        Log.e(TAG, "Coroutine exception catch error[${throwable}]")
        throwable.printStackTrace()
    }

    fun runWithCoroutines(num: Int) {
        runCoroutines(num)
    }

    private fun runCoroutines(num: Int) {
        //todo change to viewmodel scope and try to fix behavior
        coroutineScope.launch(exceptionHandler) {
            repeat(num) {
                launch(Dispatchers.Default) { imageRepo.uploadImage(it) }
            }
        }
    }
}