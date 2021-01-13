package com.better.reads.ui.main.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.better.reads.R
import com.better.reads.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setupUI()
    }

    private fun setupUI() {

        binding.buttonBarCode.setOnClickListener {
            val intent = Intent(this, BarCodeActivity::class.java)
            startActivity(intent)
        }

        binding.buttonPageAdapter.setOnClickListener {
            val intent = Intent(this, MainViewPagerActivity::class.java)
            startActivity(intent)
        }

        binding.buttonGridView.setOnClickListener {
            val intent = Intent(this, GridListMVVMActivity::class.java)
            startActivity(intent)
        }
    }
}