package com.tutorials180.clasprojecte4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.lang.Exception

class SecondScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_screen)

        receiveData()
    }

    private fun receiveData() {
        try
        {
            //var nameKey=intent.getStringExtra("name")
            //var rollNoKey=intent.getIntExtra("rollNo",0);

            var userObject=intent.getSerializableExtra("uObject") as User
            var name=userObject.returnName()

            var roll=userObject.returnRoll()
        }
        catch (ex:Exception)
        {

        }
    }
}