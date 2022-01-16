package com.tutorials180.clasprojecte4.SMSWorking

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.SmsManager
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.tutorials180.clasprojecte4.R
import com.tutorials180.clasprojecte4.databinding.ActivitySmsworkingBinding

class SMSWorkingActivity : AppCompatActivity() {

    private lateinit var mSMSWorkingBinder:ActivitySmsworkingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mSMSWorkingBinder= ActivitySmsworkingBinding.inflate(layoutInflater)
        setContentView(mSMSWorkingBinder.root)

        mSMSWorkingBinder.sendSmsBtn.setOnClickListener {
            sendCustomSMS()
        }
    }

    private fun sendCustomSMS()
    {
        try
        {
            if(ActivityCompat.checkSelfPermission(this,Manifest.permission.SEND_SMS)
            !=PackageManager.PERMISSION_GRANTED)
            {
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.SEND_SMS),100)
            }
            else {
                val currentSMSManager = SmsManager.getDefault()
                currentSMSManager.sendTextMessage(
                    "00923026666666", null,
                    "Test", null, null
                )

                Toast.makeText(applicationContext, "Sent", Toast.LENGTH_LONG).show()
            }
        }
        catch (ex:Exception)
        {
            Toast.makeText(applicationContext,ex.message,Toast.LENGTH_LONG).show()
        }
    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode==100)
        {
            if(grantResults.isNotEmpty() && grantResults[0]==PackageManager.PERMISSION_GRANTED)
            {
                Toast.makeText(applicationContext,"SMS permission granted",Toast.LENGTH_LONG).show()
            }
        }
    }
















}