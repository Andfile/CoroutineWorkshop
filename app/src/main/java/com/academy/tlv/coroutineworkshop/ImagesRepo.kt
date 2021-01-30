package com.academy.tlv.coroutineworkshop

import android.util.Log

interface ImagesRepo {
    suspend fun uploadImage(num: Int)
}

private const val TAG = "ImagesRepoImpl"

class ImagesRepoImpl : ImagesRepo {

    override suspend fun uploadImage(num: Int) {
        if (num % 5 == 0) throw ArithmeticException()
        Log.d(TAG, "upload image:[$num] started")
        Thread.sleep(2000)
        Log.d(TAG, "upload image:[$num] ended")
    }
}