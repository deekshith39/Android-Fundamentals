package com.example.edittextsdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etA = findViewById<EditText>(R.id.etA)
        val etB = findViewById<EditText>(R.id.etB)
        val etResult = findViewById<EditText>(R.id.etResult)
        val btnResult = findViewById<Button>(R.id.btnAdd)

        btnResult.setOnClickListener({
            val result = etA.text.toString().toInt() + etB.text.toString().toInt()
//            etResult.text = Editable.Factory.getInstance().newEditable(result.toString())
            etResult.setText(result.toString())
        })

    }
}