package com.example.toobarmenus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // return super.onCreateOptionsMenu(menu)
        // We don't use the above one because
        menuInflater.inflate(R.menu.app_menu_bar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.miAddContact -> Toast.makeText(this, "You clicked on Add Contact", Toast.LENGTH_SHORT).show()
            R.id.miFavorites -> Toast.makeText(this, "You Clicked on Favorites", Toast.LENGTH_SHORT).show()
            R.id.miFeedback -> Toast.makeText(this, "You Clicked on Feedback", Toast.LENGTH_SHORT).show()
            R.id.miSettings -> Toast.makeText(this, "You clicked on Settings", Toast.LENGTH_SHORT).show()
            R.id.miCloseApp -> finish()
        }
        return true
    }

}