package com.tutorials180.clasprojecte4.BroadCastReceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.wifi.WifiManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tutorials180.clasprojecte4.R
import com.tutorials180.clasprojecte4.databinding.ActivityBrworkingBinding

class BRWorkingActivity : AppCompatActivity()
{
    private lateinit var mBRBinder: ActivityBrworkingBinding
    //private lateinit var mWifiManager: WifiManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBRBinder = ActivityBrworkingBinding.inflate(layoutInflater)

//        mWifiManager = applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
//        mWifiManager.isWifiEnabled = false
        setContentView(mBRBinder.root)
    }

    private val receiver = object : BroadcastReceiver()
    {
        override fun onReceive(p0: Context?, intent: Intent?) {
           when (intent?.getIntExtra(WifiManager.EXTRA_WIFI_STATE,
               WifiManager.WIFI_STATE_UNKNOWN))
           {
               WifiManager.WIFI_STATE_ENABLED ->
               {
                   mBRBinder.brWorkingTv.text = "Wifi is enabled"
               }

               WifiManager.WIFI_STATE_DISABLED ->
               {
                   mBRBinder.brWorkingTv.text = "Wifi is disabled"
               }
               else ->
               {
                   mBRBinder.brWorkingTv.text = "Wifi is unknown"
               }
           }
        }
    }

    override fun onStart() {
        super.onStart()
        registerReceiver(receiver, IntentFilter(WifiManager.WIFI_STATE_CHANGED_ACTION))
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(receiver)
    }

}
















