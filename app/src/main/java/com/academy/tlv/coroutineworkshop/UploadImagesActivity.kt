package com.academy.tlv.coroutineworkshop

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_upload_images.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class UploadImagesActivity : AppCompatActivity() {

    private val imagesRepo: ImagesUtils = ImagesUtilsImpl()
    private val coroutineScope = CoroutineScope(Dispatchers.Main.immediate)
    private var job: Job? = null //think may be you need this?

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upload_images)
        setupViews()
    }

    private fun setupViews() {
        run_coroutines_btn.setOnClickListener {
            coroutineScope.launch {
                launch {
                    processAndUploadImage()
                }
            }
        }
    }

    private suspend fun processAndUploadImage() {
        enableTheButton(false)

        val id = downScaleImage(1)
        toast(id)
        uploadImage(id)

        enableTheButton(true)
    }

    private suspend fun downScaleImage(id: Int) = imagesRepo.processImagesDownscale(id)
    private suspend fun uploadImage(id: Int) {
        imagesRepo.uploadImage(id)
    }

    private fun enableTheButton(isEnabled: Boolean = true) {
        run_coroutines_btn.isEnabled = isEnabled
    }

    private fun toast(id: Int) {
        Toast.makeText(
            this,
            "Process for downScaling imageId:[$id] ended, upload started",
            Toast.LENGTH_SHORT
        ).show()
    }

    override fun onStop() {
        super.onStop()
        //todo implement cancellation
    }
}