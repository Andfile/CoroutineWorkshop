package com.academy.tlv.coroutineworkshop

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel(private val imageRepo: ImagesRepo = ImagesRepoImpl()) : ViewModel() {

    val duration: MutableLiveData<Long> = MutableLiveData()

    fun runWithCoroutines(num: Int) {
        runCoroutines(num)
    }

    private fun runCoroutines(num: Int) {
        //todo need to implement your first coroutine in this part
        repeat(num) {
            imageRepo.uploadImage(it)
        }
    }
}