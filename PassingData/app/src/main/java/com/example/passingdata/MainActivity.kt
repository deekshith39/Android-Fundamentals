package com.example.passingdata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnApply = findViewById<Button>(R.id.btnApply)
        val name = findViewById<EditText>(R.id.etName)
        val age = findViewById<EditText>(R.id.etAge)
        val country = findViewById<EditText>(R.id.etCountry)

        btnApply.setOnClickListener({
            Intent(this, SecondActivity::class.java).also {
                // Without using the class
//                it.putExtra("EXTRA_NAME", name.text.toString())
//                it.putExtra("EXTRA_AGE", age.text.toString().toInt())
//                it.putExtra("EXTRA_COUNTRY", country.text.toString())

                // With using the class
                val person = Person(name.text.toString(), age.text.toString().toInt(), country.text.toString())
                it.putExtra("EXTRA_PERSON", person)
                startActivity(it)
            }
        })
    }
}