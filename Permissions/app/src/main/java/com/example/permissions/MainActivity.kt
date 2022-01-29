package com.example.permissions

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.core.app.ActivityCompat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnPress = findViewById<Button>(R.id.btnRequestPermissions)
        btnPress.setOnClickListener({
            requestPermissions()
        })
    }





    private fun hasWriteExternalStoragePermission() =
            ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED

    private fun hasLocationForegroundPermission() =
            ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED

    private fun hasLocationBackgroundPermission() =
            ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_BACKGROUND_LOCATION) == PackageManager.PERMISSION_GRANTED

    private fun requestPermissions() {
        var permissonsToRequest = mutableListOf<String>()
        if(!hasLocationBackgroundPermission()) {
            permissonsToRequest.add(Manifest.permission.ACCESS_BACKGROUND_LOCATION)
        }
        if(!hasLocationForegroundPermission()) {
            permissonsToRequest.add(Manifest.permission.ACCESS_COARSE_LOCATION)
        }
        if(!hasWriteExternalStoragePermission()) {
            permissonsToRequest.add(Manifest.permission.WRITE_EXTERNAL_STORAGE)
        }

        if(permissonsToRequest.isNotEmpty()) {
            ActivityCompat.requestPermissions(this, permissonsToRequest.toTypedArray(), 0)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode == 0 && grantResults.isNotEmpty()) {
            for(i in grantResults.indices) {
                if(grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                    Log.d("PermissionRequest", "${permissions[i]} granted.")

                }
            }
        }
    }


}