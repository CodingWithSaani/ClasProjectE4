package com.tutorials180.clasprojecte4

import java.io.Serializable

class User(var name:String,var rollNo:Int):Serializable
{
   fun returnName():String
   {
       return name
   }

    fun returnRoll():Int
    {
        return rollNo
    }
}