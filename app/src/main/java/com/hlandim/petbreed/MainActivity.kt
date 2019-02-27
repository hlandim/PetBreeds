package com.hlandim.petbreed

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.hlandim.petbreed.bread.BreedsActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = Intent(baseContext, BreedsActivity::class.java)
        startActivity(intent)
    }
}
