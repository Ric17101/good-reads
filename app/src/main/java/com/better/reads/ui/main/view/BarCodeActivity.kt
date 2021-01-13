package com.better.reads.ui.main.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.better.reads.R
import com.better.reads.ui.main.fragment.BarcodeRead
import com.google.zxing.integration.android.IntentIntegrator

class BarCodeActivity : AppCompatActivity() {

    lateinit var btnBarcode: Button
    lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_barcode)
        title = "KotlinApp"
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, BarcodeRead()).commit()

        textView = findViewById(R.id.txtContent)
    }

    fun fragmentMethod() {
        Toast.makeText(
            this@BarCodeActivity, "Method called From Fragment",
            Toast.LENGTH_LONG
        ).show()
    }

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    ) {
        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        if (result != null) {
            if (result.contents == null) {
                Toast.makeText(this, "cancelled", Toast.LENGTH_SHORT).show()
            } else {
                Log.d("BarCodeActivity", "Scanned Main Activity")
                Toast.makeText(this, "Scanned -> " + result.contents, Toast.LENGTH_SHORT)
                    .show()
                textView.text = String.format("Scanned Result: %s", result)
                Log.d("BarCodeActivity", "$result")
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }
}