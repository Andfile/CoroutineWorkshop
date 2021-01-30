package com.academy.tlv.coroutineworkshop

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

interface ImagesUtils {
    suspend fun uploadImage(id: Int)
    suspend fun processImagesDownscale(id: Int): Int
}

private const val TAG = "ImagesUtilsImpl"

class ImagesUtilsImpl : ImagesUtils {

    override suspend fun uploadImage(id: Int) {
        withContext(Dispatchers.Default) {
            Log.d(TAG, "upload image:[$id] started")
            delay(2000)
            Log.d(TAG, "upload image:[$id] ended")
        }
    }

    override suspend fun processImagesDownscale(id: Int): Int = withContext(Dispatchers.Default) {
        Log.d(TAG, "down Scaling image:[$id] started")
        repeat(1000) {
            delay(2) // you need to create another suspend point by some ways, yield() or suspend function delay, or something that can create suspend point
            if (it % 100 == 0) {
                 Log.d(TAG, "downscaling step:[${it / 10}%]")
            }
        }
        Log.d(TAG, "down Scaling  image:[$id] ended")
        id
    }
}