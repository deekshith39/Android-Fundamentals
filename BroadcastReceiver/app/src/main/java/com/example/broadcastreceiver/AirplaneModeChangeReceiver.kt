package com.example.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class AirplaneModeChangeReceiver: BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        val isAirplanModeEnabled = intent?.getBooleanExtra("state", false) ?: return
        if(isAirplanModeEnabled) {
            Toast.makeText(context, "Airplane Mode Enabled", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Airplane mode disabled", Toast.LENGTH_LONG).show()
        }
    }

}