package com.example.imageviewsdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ivImage = findViewById<ImageView>(R.id.ivImage)
        val btnButton = findViewById<Button>(R.id.btnButton)

        ivImage.setOnClickListener({
            ivImage.setImageResource(R.drawable.anime)
        })

    }
}