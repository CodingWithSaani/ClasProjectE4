package com.tutorials180.clasprojecte4.SimpleRoomImplementation.RoomEntities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "teacher_record")
data class Teacher (
    @PrimaryKey val id:Int,
    @ColumnInfo(name="teacherName") val name:String)
