package com.tutorials180.clasprojecte4.SimpleRoomImplementation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.room.Room
import com.tutorials180.clasprojecte4.R
import com.tutorials180.clasprojecte4.SimpleRoomImplementation.RoomDb.StudentDb
import com.tutorials180.clasprojecte4.SimpleRoomImplementation.RoomEntities.Student
import com.tutorials180.clasprojecte4.databinding.ActivitySimpleRoomImpBinding
import java.lang.Exception

class SimpleRoomImpActivity : AppCompatActivity()
{
    private lateinit var mSimpleRoomBinding:ActivitySimpleRoomImpBinding //Declaration
    private lateinit var mStudentDb:StudentDb //Declaration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mSimpleRoomBinding= ActivitySimpleRoomImpBinding.inflate(layoutInflater)
        setContentView(mSimpleRoomBinding.root)

        createDb()
        mSimpleRoomBinding.roomStdSaveRecordBtn.setOnClickListener { addStudentData() }

        mSimpleRoomBinding.roomStdFetchRecordBtn.setOnClickListener { getStudentsData() }
    }

    private fun getStudentsData()
    {
        try
        {
            val listOfStudents=mStudentDb.getStudentDaoObject().getAllStudents()
            if(listOfStudents.isNotEmpty())
            {
               //We will show student data
               Toast.makeText(applicationContext,
                   "id of student: ${listOfStudents[0].id.toString()}" +
                           "\n name of student:${listOfStudents[0].name}" +
                           "\n email of student: ${listOfStudents[0].email}",Toast.LENGTH_LONG).show()
            }
            else
            {
                Toast.makeText(applicationContext,"No record found",Toast.LENGTH_LONG).show()
            }
        }
        catch (ex:Exception)
        {
            Toast.makeText(applicationContext,ex.message,Toast.LENGTH_LONG).show()
        }
    }

    private fun addStudentData()
    {
        try
        {
            if(mSimpleRoomBinding.roomStdIdEt.text.toString().isNotBlank()
                && mSimpleRoomBinding.roomStdNameEt.text.toString().isNotBlank()
                && mSimpleRoomBinding.roomStdEmailEt.text.toString().isNotBlank())
            {
                //we will add student data
                //Step 1: Fetch all the data from editTexts
                val id=mSimpleRoomBinding.roomStdIdEt.text.toString().toInt()
                val name=mSimpleRoomBinding.roomStdNameEt.text.toString()

                val email=mSimpleRoomBinding.roomStdEmailEt.text.toString()

                //Step 2: Create Student Object
                val currentStudent=Student(id,name,email)

                //Step 3: Add student object to database
                val checkIfDataInserted=mStudentDb.getStudentDaoObject().addStudent(currentStudent)

                if(checkIfDataInserted!=0L)
                {
                    Toast.makeText(applicationContext,"Student Added",Toast.LENGTH_LONG).show()
                }
                else
                {
                    Toast.makeText(applicationContext,"Student Not Added",Toast.LENGTH_LONG).show()
                }
            }
            else
            {
                Toast.makeText(applicationContext,"Some fields left empty",Toast.LENGTH_LONG).show()
            }
        }
        catch (ex:Exception)
        {
            Toast.makeText(applicationContext,ex.message,Toast.LENGTH_LONG).show()
        }
    }

    private fun createDb()
    {
        try
        {
            mStudentDb= Room.databaseBuilder(applicationContext,StudentDb::class.java,"StudentDb")
                .allowMainThreadQueries().build()
        }
        catch (ex:Exception)
        {
            Toast.makeText(applicationContext,ex.message,Toast.LENGTH_LONG).show()
        }
    }
}


















