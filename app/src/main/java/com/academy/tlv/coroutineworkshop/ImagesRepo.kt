package com.academy.tlv.coroutineworkshop

import android.util.Log

interface ImagesRepo {
    fun uploadImage(num: Int)
}

private const val TAG = "ImagesRepoImpl"

class ImagesRepoImpl : ImagesRepo {

    override fun uploadImage(num: Int) {
        if (num % 5 == 0) throw ArithmeticException()
        Log.d(TAG, "upload image:[$num] started")
        Thread.sleep(2000) //todo section 4 discuss about delay instead of Thread.sleep
        Log.d(TAG, "upload image:[$num] ended")
    }
}