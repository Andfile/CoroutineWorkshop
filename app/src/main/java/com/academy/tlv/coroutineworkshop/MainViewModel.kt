package com.academy.tlv.coroutineworkshop

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class MainViewModel(private val imageRepo: ImagesRepo = ImagesRepoImpl()) : ViewModel() {

    private val coroutineScope = CoroutineScope(Dispatchers.Default)

    fun runWithCoroutines(num: Int) {
        runCoroutines(num)
    }

    private fun runCoroutines(num: Int) {
        //todo need to implement your first coroutine in this part
        //todo coroutineScope will help you to launch your first coroutine
        repeat(num) {
            val downScaleResult = coroutineScope.async { imageRepo.processImageDownScale(it) }
            coroutineScope.launch { imageRepo.uploadImage(downScaleResult.await()) }
        }
    }
}