package com.example.fragmentsdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnFragment1 = findViewById<Button>(R.id.btnFragment1)
        val btnFragment2 = findViewById<Button>(R.id.btnFragment2)

        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()

        // setting initial fragment to the container
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, firstFragment)
            commit()
        }

        btnFragment1.setOnClickListener({
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, firstFragment)
                // by Default fragment are not added to the stack, so we do this
                addToBackStack("firstFragment")
                commit()
            }
        })

        btnFragment2.setOnClickListener({
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, secondFragment)
                addToBackStack("secondFragment")
                commit()
            }
        })

    }
}