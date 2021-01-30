package com.academy.tlv.coroutineworkshop

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

interface ImagesRepo {
    suspend fun uploadImage(num: Int)
}

private const val TAG = "ImagesRepoImpl"

class ImagesRepoImpl : ImagesRepo {

    override suspend fun uploadImage(num: Int) {
        withContext(Dispatchers.IO) {
            if (num % 5 == 0) throw ArithmeticException()
            Log.d(TAG, "upload image:[$num] started")
            delay(2000)
            Log.d(TAG, "upload image:[$num] ended")
        }
    }
}