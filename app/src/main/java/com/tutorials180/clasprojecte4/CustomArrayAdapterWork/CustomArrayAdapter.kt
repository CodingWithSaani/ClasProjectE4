package com.tutorials180.clasprojecte4.CustomArrayAdapterWork

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.tutorials180.clasprojecte4.R

class CustomArrayAdapter (context:Context,var playersData:List<CricketPlayer>)
    :ArrayAdapter<CricketPlayer>(context, R.layout.custom_row_for_player_adapter,playersData)
{
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var singleRow=LayoutInflater.from(context).inflate(R.layout.custom_row_for_player_adapter,
        null,true)

        var nameOfPlayerTV:TextView=singleRow.findViewById(R.id.custom_player_name_tv)
        var battingStyleOfPlayer=singleRow.findViewById(R.id.custom_player_batting_style_tv) as TextView
        var playerImage=singleRow.findViewById(R.id.custom_player_iv) as ImageView

        nameOfPlayerTV.text=playersData.get(position).getPName()
        battingStyleOfPlayer.text=playersData.get(position).getPBattingStyle()

        playerImage.setImageResource(playersData.get(position).getPlayerImage())
        return singleRow
    }
}