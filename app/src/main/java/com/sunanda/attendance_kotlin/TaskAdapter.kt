package com.sunanda.attendance_kotlin

import android.annotation.SuppressLint
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date

class TaskAdapter(internal var context: Context, private val stringList: List<TaskPojo>) : RecyclerView.Adapter<TaskAdapter.MyViewHolder>() {

    inner class MyViewHolder (view: View) : RecyclerView.ViewHolder(view) {

        val address: TextView = view.findViewById(R.id.address)
        internal val date: TextView
        val task: TextView

        init {
            task = view.findViewById(R.id.task)
            date = view.findViewById(R.id.date)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskAdapter.MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.task, parent, false)

        return MyViewHolder(itemView)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: TaskAdapter.MyViewHolder, position: Int) {
        val taskPojo = stringList[position]
        holder.address.text = taskPojo.address
        //holder.date.setText(taskPojo.getUpdatedAt());
        holder.task.text = taskPojo.task

        val DATE_FORMAT = "yyyy-MM-dd HH:mm:ss"
        @SuppressLint("SimpleDateFormat")
        val sdf = SimpleDateFormat(DATE_FORMAT)
        val date: Date
        try {
            date = sdf.parse(taskPojo.updatedAt)
            val calendar = Calendar.getInstance()
            calendar.time = date
            calendar.add(Calendar.HOUR, 5)
            calendar.add(Calendar.MINUTE, 30)
            //System.out.println("Time" + calendar.getTime().toString().split(" ")[3]);
            holder.date.text = "\u23f0 Submitted At : " + calendar.time.toString().split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()[3]
        } catch (e: ParseException) {
            e.printStackTrace()
        }

    }

    override fun getItemCount(): Int {
        return stringList.size
    }
}


