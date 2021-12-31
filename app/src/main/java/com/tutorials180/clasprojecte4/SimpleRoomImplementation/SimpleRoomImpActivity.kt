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


/*
 ROOM Lib
 => Components
    1- Database
    2- Entity or Entities
        table(s)
    3- Data access objects
        DAO (CRUD) ->inserting some value, updating some value, deleting some value

    Example
    Step 1: We created three separate packages RoomDAO, RoomDb, RoomEntities
    Step 2: We created tables(Entities) of student and teacher
    Step 3: We created the DAO for student (CRUD)
    Step 4: We created out Database abstract class

    31-12-21
    Step 1: we created a method in StudentDb class which will return
            StudentDao object
    Step 2: we created xml layout to get student id, name, and email
    Step 3: we created a view binding object to get all views of xml in kotlin file.
    Step 4: we create and initialized StudentDb object
    Step 5: we called the createDb() method inside onCreate() method.

    Important points:
    <> you will always get DAO object from the database class.
    <> Room does not allow queries to run on main thread.
 */
















