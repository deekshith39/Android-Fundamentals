package com.example.spinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spMonths = findViewById<Spinner>(R.id.spMonths)

        // If the list is not pre-defined in the xml file, we do this
        val customList = listOf("First", "Second", "Third", "Fourth")
        val adapter = ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, customList)
        spMonths.adapter = adapter


        spMonths.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(adapterView: AdapterView<*>?, view: View?, position: Int, Id: Long) {
                // If we use this here at the context, then we will be referring to the OnItemSelectedListener, so we mention applicationContext
                Toast.makeText(applicationContext, "You selected ${adapterView?.getItemAtPosition(position).toString()}", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }
    }
}