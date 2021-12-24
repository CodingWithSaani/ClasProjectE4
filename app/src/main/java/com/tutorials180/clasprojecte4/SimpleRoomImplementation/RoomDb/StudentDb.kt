package com.tutorials180.clasprojecte4.SimpleRoomImplementation.RoomDb

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tutorials180.clasprojecte4.SimpleRoomImplementation.RoomEntities.Student
import com.tutorials180.clasprojecte4.SimpleRoomImplementation.RoomEntities.Teacher

@Database (entities = [Student::class, Teacher::class], version = 1 )
abstract class StudentDb : RoomDatabase()
{

}