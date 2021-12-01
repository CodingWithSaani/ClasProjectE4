package com.tutorials180.clasprojecte4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.tutorials180.clasprojecte4.AdaptersWork.ListTaskOne
import com.tutorials180.clasprojecte4.Dialogs.AlertDialogScreen

class MainActivity : AppCompatActivity()
{


    private lateinit var moveBtn:Button
    private lateinit var moveToAlertDialogScreen:Button

    private lateinit var moveToListScreen:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        connectXML()
    }

    private fun connectXML()
    {
       moveBtn=findViewById(R.id.move_btn)
       moveToAlertDialogScreen=findViewById(R.id.move_to_alert_screen_btn)

       moveToListScreen=findViewById(R.id.move_to_list_screen_btn)
       moveBtn.setOnClickListener {
           moveToSecondPage()
       }

       moveToAlertDialogScreen.setOnClickListener {
           moveToAlertDiaScreen()
       }

       moveToListScreen.setOnClickListener {
           moveToListTaskOneScreen()
       }
    }

    private fun moveToListTaskOneScreen() {
        try
        {
            startActivity(Intent(this,ListTaskOne::class.java))
        }
        catch (ex:Exception)
        {
            Toast.makeText(this,"Logical Error:${ex.message.toString()}"
                ,Toast.LENGTH_LONG).show()
        }
    }

    private fun moveToAlertDiaScreen() {
        try
        {
            startActivity(Intent(this,AlertDialogScreen::class.java))
        }
        catch (ex:Exception)
        {
            Toast.makeText(this,"Logical Error:${ex.message.toString()}"
            ,Toast.LENGTH_LONG).show()
        }
    }

    private fun moveToSecondPage() {
        try {
            //Demo objectDemo=new Demo()
            var objectIntent= Intent(this,SecondScreen::class.java);
            //objectIntent.putExtra("name","Farrukh Ehsan")

            //objectIntent.putExtra("rollNo",123)
            var userObject=User("Farrukh",123)
            objectIntent.putExtra("uObject",userObject)
            startActivity(objectIntent)
        }
        catch (ex:Exception)
        {

        }

    }
}