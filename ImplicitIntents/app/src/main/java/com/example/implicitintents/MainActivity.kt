package com.example.implicitintents

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnTakePhoto = findViewById<Button>(R.id.btnTakePhoto)


        btnTakePhoto.setOnClickListener({
            Intent(Intent.ACTION_GET_CONTENT).also {
                it.type = "image/*"
                 startActivityForResult(it, 0)
            }
        })
    }

    // The one we are using above is called the implicit intents where the intent takes an action
    // and of type image, so we get the images available.
    // We use the startActivityForResult because we need the result of the action .i.e, in this case selcted image
    // request code is specific for an intent, mainly useful when there are many intents

    // The below function is basically used to fetch the result of the above function, i.e, the image selected attributes
    // requestCode - It should be the same as the above one
    // resultCode - Success or Failure
    // data - data result -> Image in this case


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK && requestCode == 0) {
            val ivPhoto = findViewById<ImageView>(R.id.ivPhoto)
            val uri = data?.data
            ivPhoto.setImageURI(uri)
        }
    }

}