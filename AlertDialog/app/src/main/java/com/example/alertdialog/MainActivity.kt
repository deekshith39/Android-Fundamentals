package com.example.alertdialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnDialog1 = findViewById<Button>(R.id.btnDialog1)
        val btnDialog2 = findViewById<Button>(R.id.btnDialog2)
        val btnDialog3 = findViewById<Button>(R.id.btnDialog3)

        val addContactDialog = AlertDialog.Builder(this)
            .setTitle("Add Contact")
            .setMessage("Do you want add this guy to your contact list?")
            .setIcon(R.drawable.ic_add_contact)
            .setPositiveButton("Yes") { _, _ ->
                Toast.makeText(this, "You added the contact", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("No") { _, _ ->
                Toast.makeText(this, "You did not add the contact", Toast.LENGTH_SHORT).show()
            }.create()

        btnDialog1.setOnClickListener({
            addContactDialog.show()
        })

        val options = arrayOf("First Item", "Second Item", "Third Item")
        val singleChoiceOption = AlertDialog.Builder(this)
            .setTitle("Choose the right one")
            .setSingleChoiceItems(options, 0) { _, i ->
                Toast.makeText(this, "You have selected ${options[i]}", Toast.LENGTH_SHORT).show()
            }.setPositiveButton("Accept") { _, _ ->
                Toast.makeText(this, "You Accepted", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Reject") { _, _ ->
                Toast.makeText(this, "You Rejected", Toast.LENGTH_SHORT).show()
            }.create()

        btnDialog2.setOnClickListener({
            singleChoiceOption.show()
        })

        val multipleChoiceOption = AlertDialog.Builder(this)
            .setTitle("Choose the right one")
            .setMultiChoiceItems(options, booleanArrayOf(false, false, false)) { _, i, isChecked ->
                if(isChecked) {
                    Toast.makeText(this, "You checked ${options[i]}", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "You unchecked ${options[i]}", Toast.LENGTH_SHORT).show()
                }
            }
            .setPositiveButton("Accept") { _, _ ->
                Toast.makeText(this, "You Accepted", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Reject") { _, _ ->
                Toast.makeText(this, "You Rejected", Toast.LENGTH_SHORT).show()
            }.create()

        btnDialog3.setOnClickListener({
            multipleChoiceOption.show()
        })

    }
}