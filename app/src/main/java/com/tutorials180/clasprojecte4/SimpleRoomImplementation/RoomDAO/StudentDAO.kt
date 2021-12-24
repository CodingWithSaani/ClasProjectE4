package com.tutorials180.clasprojecte4.SimpleRoomImplementation.RoomDAO

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.tutorials180.clasprojecte4.SimpleRoomImplementation.RoomEntities.Student

@Dao
interface StudentDAO
{
    @Insert
    fun addStudent(objStudent: Student):Long  //In case of successful insertion it will return long value other than zero

    @Query("select * from student_record")
    fun getAllStudents():List<Student>
}