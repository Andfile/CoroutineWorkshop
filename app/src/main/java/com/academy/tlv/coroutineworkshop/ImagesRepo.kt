package com.academy.tlv.coroutineworkshop

import android.util.Log
import kotlinx.coroutines.delay
import kotlin.random.Random

interface ImagesRepo {
    fun uploadImage(num: Int)
    suspend fun processImageDownScale(num: Int): Int
}

private const val TAG = "ImagesRepoImpl"

class ImagesRepoImpl : ImagesRepo {

    override fun uploadImage(num: Int) {
        Log.d(TAG, "upload image:[$num] started")
        Thread.sleep(2000)
        Log.d(TAG, "upload image:[$num] ended")
    }

    override suspend fun processImageDownScale(num: Int): Int {
        val random = Random.nextLong(100, 2000)
        delay(random)
        Log.d(TAG, "process downscale duration:[$random] for image:[$num] complete")
        return num * 2
    }
}