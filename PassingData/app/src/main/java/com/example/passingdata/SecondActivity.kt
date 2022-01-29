package com.example.passingdata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import org.w3c.dom.Text

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // Without using class
//        val name = intent.getStringExtra("EXTRA_NAME")
//        val age = intent.getIntExtra("EXTRA_AGE", 0)
//        val country = intent.getStringExtra("EXTRA_COUNTRY")

        // With using class
        val person = intent.getSerializableExtra("EXTRA_PERSON") as Person
        // above "getSerailzeableExtra returns the Serializeable type and so it has to be casted as object


        val tvText = findViewById<TextView>(R.id.tvText)

//        val personString = "$name's age is $age and he/she lives in $country"

        tvText.text = person.toString()
    }
}