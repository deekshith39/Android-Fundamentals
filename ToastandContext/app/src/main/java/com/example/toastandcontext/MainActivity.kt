package com.example.toastandcontext

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.widget.Button
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnshowToast = findViewById<Button>(R.id.btnToast)
        val clToast = findViewById<ConstraintLayout>(R.id.clToast)
        btnshowToast.setOnClickListener({
            // Built-in Toast
            Toast.makeText(applicationContext, "Hi, I'm a toast!", Toast.LENGTH_LONG).show()

            // Custom Toast
//            Toast(this).apply {
//                duration = Toast.LENGTH_LONG
//                view = layoutInflater.inflate(R.layout.custom_toast, clToast)
//                show()
//            }

            val toast = Toast(this)
            toast.duration = Toast.LENGTH_LONG
            toast.view = layoutInflater.inflate(R.layout.custom_toast, clToast)
            toast.show()

        })

    }
}