package com.tutorials180.clasprojecte4.CustomArrayAdapterWork

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.tutorials180.clasprojecte4.R
import com.tutorials180.clasprojecte4.databinding.ActivityCustomListPageBinding
import java.lang.Exception

class CustomListPage : AppCompatActivity() {

    private lateinit var customListPageBindingObject:ActivityCustomListPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        customListPageBindingObject= ActivityCustomListPageBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_custom_list_page)
    }

    private fun createPlayerObjects()
    {
        try
        {
            var objAzharAli=CricketPlayer("Azhar Ali","Right Hand Batsman",R.drawable.azhar_ali)
            var objMohammadBabarAzam=CricketPlayer("Babar Azam","Right Hand Batsman",R.drawable.mohammad_babar_azam)

            var objAzharAli1=CricketPlayer("Azhar Ali","Right Hand Batsman",R.drawable.azhar_ali)
            var objMohammadBabarAzam1=CricketPlayer("Babar Azam","Right Hand Batsman",R.drawable.mohammad_babar_azam)

            var objAzharAli2=CricketPlayer("Azhar Ali","Right Hand Batsman",R.drawable.azhar_ali)
            var objMohammadBabarAzam2=CricketPlayer("Babar Azam","Right Hand Batsman",R.drawable.mohammad_babar_azam)

            var objAzharAli3=CricketPlayer("Azhar Ali","Right Hand Batsman",R.drawable.azhar_ali)
            var objMohammadBabarAzam3=CricketPlayer("Babar Azam","Right Hand Batsman",R.drawable.mohammad_babar_azam)

            var objAzharAli4=CricketPlayer("Azhar Ali","Right Hand Batsman",R.drawable.azhar_ali)
            var objMohammadBabarAzam4=CricketPlayer("Babar Azam","Right Hand Batsman",R.drawable.mohammad_babar_azam)

            var objAzharAli5=CricketPlayer("Azhar Ali","Right Hand Batsman",R.drawable.azhar_ali)
            var objMohammadBabarAzam5=CricketPlayer("Babar Azam","Right Hand Batsman",R.drawable.mohammad_babar_azam)

            var objAzharAli6=CricketPlayer("Azhar Ali","Right Hand Batsman",R.drawable.azhar_ali)
            var objMohammadBabarAzam6=CricketPlayer("Babar Azam","Right Hand Batsman",R.drawable.mohammad_babar_azam)


        }
        catch (ex:Exception)
        {
            Toast.makeText(CustomListPage@this,"Logical Error:${ex.message}",Toast.LENGTH_LONG).show()
        }
    }
}