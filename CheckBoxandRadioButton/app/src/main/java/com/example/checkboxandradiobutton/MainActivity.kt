package com.example.checkboxandradiobutton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnOrder = findViewById<Button>(R.id.btnOrder)
        val rgBurger = findViewById<RadioGroup>(R.id.rgBurger)
        val tvOrder = findViewById<TextView>(R.id.tvOrder)
        val cbOnion = findViewById<CheckBox>(R.id.cbOnion)
        val cbSalad = findViewById<CheckBox>(R.id.cbSalad)
        val cbCheese = findViewById<CheckBox>(R.id.cbCheese)

        btnOrder.setOnClickListener({
            val checkedRadioButtonId = rgBurger.checkedRadioButtonId
            val burger = findViewById<RadioButton>(checkedRadioButtonId)

            val list = mutableListOf<String>()
            if(cbOnion.isChecked) {
                list.add(cbOnion.text.toString())
            }
            if(cbCheese.isChecked) {
                list.add(cbCheese.text.toString())
            }
            if(cbSalad.isChecked) {
                list.add(cbSalad.text.toString())
            }

            var orderString = "${burger.text}" + "\n"

            for(item in list) {
                orderString += "$item" + "\n"
            }

            tvOrder.text = orderString

        })
    }
}