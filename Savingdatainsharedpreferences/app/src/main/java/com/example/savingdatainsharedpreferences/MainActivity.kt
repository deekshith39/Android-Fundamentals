package com.example.savingdatainsharedpreferences

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPref = getSharedPreferences("myPref", Context.MODE_PRIVATE)
        // second parameter: Mode
        // 1. Public : which means other apps also can access our shared preferences
        // 2. Private : which means other apps cannot access our shared preferences
        // 3. Override : override the earlier preferences

        val editor = sharedPref.edit()

        val btnSave = findViewById<Button>(R.id.btnSave)
        val btnLoad = findViewById<Button>(R.id.btnLoad)

        btnSave.setOnClickListener({
            val name = findViewById<EditText>(R.id.etName).text.toString()
            val age = findViewById<EditText>(R.id.etAge).text.toString().toInt()
            val isAdult = findViewById<CheckBox>(R.id.cbAdult).isChecked

            // All the data that is shared preferences is shared as key-value pairs
            editor.apply {
                putString("name", name)
                putInt("age", age)
                putBoolean("isAdult", isAdult)
                apply()
            }
        })

        btnLoad.setOnClickListener({
            val name = sharedPref.getString("name", null)
            val age = sharedPref.getInt("age", 0)
            val isAdult = sharedPref.getBoolean("isAdult", false)

            findViewById<EditText>(R.id.etName).setText(name)
            findViewById<EditText>(R.id.etAge).setText(age.toString())
            findViewById<CheckBox>(R.id.cbAdult).isChecked = isAdult
        })

    }
}