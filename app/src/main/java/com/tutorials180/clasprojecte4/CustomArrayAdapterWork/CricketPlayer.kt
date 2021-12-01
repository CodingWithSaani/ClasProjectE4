package com.tutorials180.clasprojecte4.CustomArrayAdapterWork

class CricketPlayer (name:String,battingStyle:String, playerImage:Int)
{
    private var pName=name
    private var pBattingStyle=battingStyle

    private var pPlayerImage=playerImage

    fun getPName():String
    {
        return pName
    }

    fun getPBattingStyle():String
    {
        return pBattingStyle
    }

    fun getPlayerImage():Int{
        return pPlayerImage
    }

}