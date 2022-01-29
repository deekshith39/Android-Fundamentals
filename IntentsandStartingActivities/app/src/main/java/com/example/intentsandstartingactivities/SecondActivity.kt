package com.example.intentsandstartingactivities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val btnBack = findViewById<Button>(R.id.btnBack)

        btnBack.setOnClickListener({
            finish() // removes/pops from the application stack
        })
    }
}