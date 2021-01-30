package com.academy.tlv.coroutineworkshop

import junit.framework.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Test

class ImagesRepoImplTest {

    lateinit var imagesRepo: ImagesRepo

    @Test
    fun testForTheImagesRepoDownScaleFun() {
        imagesRepo = ImagesRepoImpl()
        val processedImageId = runBlocking {
            imagesRepo.processImageDownScale(4)
        }
        assertEquals(processedImageId, 8)
    }
}