package com.tutorials180.clasprojecte4.SimpleRoomImplementation.RoomEntities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "student_record")
data class Student (
    @PrimaryKey val id:Int,
    @ColumnInfo(name = "studentName") val name:String,
    @ColumnInfo(name = "studentEmail") val email:String)
