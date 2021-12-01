package com.tutorials180.clasprojecte4.Dialogs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.tutorials180.clasprojecte4.R

class AlertDialogScreen : AppCompatActivity() {

    private lateinit var alertDialogBuilder: AlertDialog.Builder
    private lateinit var alertDialog:AlertDialog

    private lateinit var showAlertDialogBtn:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alert_dialog_screen)

        connectXML()
    }

    private fun connectXML() {
        try
        {
            showAlertDialogBtn=findViewById(R.id.show_dialog_btn)
            showAlertDialogBtn.setOnClickListener {
                createAlertDialog()
            }
        }
        catch (ex:Exception)
        {
            Toast.makeText(this,"Logical Error:${ex.message.toString()}"
                , Toast.LENGTH_LONG).show()
        }
    }


    private fun createAlertDialog()
    {
        try
        {
            alertDialogBuilder=AlertDialog.Builder(this)
            alertDialogBuilder.setTitle("Test")

            alertDialogBuilder.setMessage("Some Test Information")
            alertDialogBuilder.setCancelable(false)

            alertDialogBuilder.setPositiveButton("Close"){
                d,id->
                alertDialog.dismiss()
            }

            alertDialog=alertDialogBuilder.create()
            alertDialog.show()
        }
        catch (ex:Exception)
        {
            Toast.makeText(this,"Logical Error:${ex.message.toString()}"
                , Toast.LENGTH_LONG).show()
        }
    }















}