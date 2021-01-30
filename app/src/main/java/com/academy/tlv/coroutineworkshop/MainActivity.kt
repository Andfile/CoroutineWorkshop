package com.academy.tlv.coroutineworkshop

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViews()
        setupViewModel()
    }

    private fun setupViews() {
        run_coroutines_btn.setOnClickListener {
            val num = num_processes_edt.text.toString()
            //may throw ex
            mainViewModel.runWithCoroutines(num.toInt())
        }
    }

    private fun setupViewModel() {
        mainViewModel.duration.observe(this, {

        })
    }
}