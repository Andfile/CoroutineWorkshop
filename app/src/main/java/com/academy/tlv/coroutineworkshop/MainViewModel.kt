package com.academy.tlv.coroutineworkshop

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.supervisorScope

private const val TAG = "MainViewModel"

class MainViewModel(private val imageRepo: ImagesRepo = ImagesRepoImpl()) : ViewModel() {

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        Log.e(TAG, "Coroutine exception catch error[${throwable}]")
        throwable.printStackTrace()
    }

    fun runWithCoroutines(num: Int) {
        runCoroutines(num)
    }

    private fun runCoroutines(num: Int) {
        viewModelScope.launch(exceptionHandler) {
            supervisorScope {
                repeat(num) {
                    launch(Dispatchers.Default) { imageRepo.uploadImage(it) }
                }
            }
        }
    }
}