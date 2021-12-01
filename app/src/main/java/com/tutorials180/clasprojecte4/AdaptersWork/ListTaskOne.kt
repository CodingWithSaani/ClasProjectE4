package com.tutorials180.clasprojecte4.AdaptersWork

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.tutorials180.clasprojecte4.MainActivity
import com.tutorials180.clasprojecte4.R

class ListTaskOne : AppCompatActivity() {

    val listOfDay= listOf<String>("Monday","Tuesday","Wednesday","Thursday"
    ,"Friday","Saturday","Sunday")

    private lateinit var listView:ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_task_one)

        connector()
    }

    private fun connector()
    {
        try
        {
            listView=findViewById(R.id.list_view)
            mapDataToListView()
        }
        catch (objectEx:Exception)
        {
            Toast.makeText(ListTaskOne@this,"Logical Error:${objectEx.message}",
            Toast.LENGTH_LONG).show()
        }
    }

    private fun mapDataToListView()
    {
        try
        {
            val myArrayAdapter=ArrayAdapter<String>(ListTaskOne@this,
                android.R.layout.simple_list_item_1,
            listOfDay)

            listView.adapter=myArrayAdapter
            listView.setOnItemClickListener { parent, view, position, id ->

                //Data.....
            }

        }
        catch (objectEx:Exception)
        {
            Toast.makeText(ListTaskOne@this,"Logical Error:${objectEx.message}",
                Toast.LENGTH_LONG).show()
        }
    }








}