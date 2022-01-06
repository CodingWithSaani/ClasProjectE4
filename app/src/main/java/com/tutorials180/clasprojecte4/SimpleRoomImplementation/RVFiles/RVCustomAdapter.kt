package com.tutorials180.clasprojecte4.SimpleRoomImplementation.RVFiles

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tutorials180.clasprojecte4.R
import com.tutorials180.clasprojecte4.SimpleRoomImplementation.RoomEntities.Student

class RVCustomAdapter(context:Context,val studentList:List<Student>):RecyclerView.Adapter<RVCustomAdapter.SingleRowViewHolder>()
{
    class SingleRowViewHolder(singleRow: View): RecyclerView.ViewHolder(singleRow)
    {
        var studentIDTV=singleRow.findViewById<TextView>(R.id.rv_sr_std_id_tv)
        var studentNameTV=singleRow.findViewById<TextView>(R.id.rv_sr_std_name_tv)

        var studentEmailTV=singleRow.findViewById<TextView>(R.id.rv_sr_std_email_tv)
    }

    //1
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SingleRowViewHolder
    {
        val singleRow= LayoutInflater.from(parent.context).inflate(R.layout.rv_single_row,parent,false)
        val viewHolder=SingleRowViewHolder(singleRow)

        return viewHolder
    }

    //2
    override fun onBindViewHolder(holder: SingleRowViewHolder, position: Int) {

        holder.studentIDTV.text=studentList[position].id.toString()
        holder.studentNameTV.text=studentList[position].name

        holder.studentEmailTV.text=studentList[position].email
    }

    //3
    override fun getItemCount(): Int {
        return studentList.size
    }

}