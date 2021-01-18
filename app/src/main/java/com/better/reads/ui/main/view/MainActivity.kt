package com.better.reads.ui.main.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.better.reads.R
import com.better.reads.databinding.ActivityMainBinding
import com.better.reads.ui.main.dialog.ConfirmationDialogFragment


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

        binding.buttonDialogFragment.setOnClickListener {
            val dialog = ConfirmationDialogFragment.newInstance(getString(R.string.info_unsaved_data)).apply {
                setOnOkClicked {
                    // do something
                }
                setOnCancelClicked {
                    // do something
                }
            }
            dialog.show(supportFragmentManager, null)
        }
    }
}