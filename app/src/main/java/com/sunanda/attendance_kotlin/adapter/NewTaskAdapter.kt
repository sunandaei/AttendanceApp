package com.sunanda.attendance_kotlin.adapter

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.AsyncTask
import android.support.v7.app.AlertDialog
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.sunanda.attendance_kotlin.R
import com.sunanda.attendance_kotlin.database.DatabaseHandler
import com.sunanda.attendance_kotlin.model.NewTaskPojo
import com.sunanda.attendance_kotlin.room.DatabaseClient
import com.sunanda.attendance_kotlin.room.TaskPojoUsingRoom


class NewTaskAdapter(internal var activity: Activity, private val stringList: ArrayList<NewTaskPojo>) :
        RecyclerView.Adapter<NewTaskAdapter.MyViewHolder>() {

    lateinit var databaseHandler: DatabaseHandler

    inner class MyViewHolder (view: View) : RecyclerView.ViewHolder(view) {

        val address: TextView = view.findViewById(R.id.address)
        val date: TextView
        val task: TextView
        val editData: ImageView
        val deleteData: ImageView

        init {
            task = view.findViewById(R.id.task)
            date = view.findViewById(R.id.date)
            editData = view.findViewById(R.id.editData)
            deleteData = view.findViewById(R.id.deleteData)
            databaseHandler = DatabaseHandler(activity)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.task, parent, false)

        return MyViewHolder(itemView)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val taskPojo = stringList[position]
        holder.address.text = taskPojo.address
        //holder.date.setText(taskPojo.getUpdatedAt());
        holder.task.text = "➤ " + taskPojo.task

        /*val DATE_FORMAT = "yyyy-MM-dd HH:mm:ss"
        @SuppressLint("SimpleDateFormat")
        val sdf = SimpleDateFormat(DATE_FORMAT)
        val date: Date
        try {
            date = sdf.parse(taskPojo.time)
            val calendar = Calendar.getInstance()
            calendar.time = date
            calendar.add(Calendar.HOUR, 5)
            calendar.add(Calendar.MINUTE, 30)
            //System.out.println("Time" + calendar.getTime().toString().split(" ")[3]);
            holder.date.text = "\u23f0 Submitted At : " + calendar.time.toString().split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()[3]
        } catch (e: ParseException) {
            e.printStackTrace()
        }*/

        holder.date.text = "\u23f0 Created at : " + taskPojo.time

        holder.deleteData.setOnClickListener {

            AlertDialog.Builder(activity)
                    .setTitle("Delete entry")
                    .setMessage("Are you sure you want to delete this entry?")
                    .setPositiveButton(android.R.string.yes) { dialog, which ->
                        //databaseHandler.deleteData(stringList[position]._id.toString())
                        notifyDataSetChanged()
                        //or use this for better performance.
                        notifyItemRemoved(position)
                        stringList.removeAt(position)
                        if (stringList.size == 0) {
                            activity.overridePendingTransition(R.anim.right_in, R.anim.left_out)
                            activity.finish()
                        }
                    }
                    .setNegativeButton(android.R.string.no, null)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setCancelable(false)
                    .show()
        }

        holder.editData.setOnClickListener {
            showDialog(position)
        }

        if (taskPojo.task.equals("Attendance In", true)) {
            holder.editData.visibility = View.GONE
            holder.deleteData.visibility = View.GONE
        } else {
            holder.editData.visibility = View.VISIBLE
            holder.deleteData.visibility = View.VISIBLE
        }
    }

    private fun showDialog(position: Int) {
        val builder = AlertDialog.Builder(activity)
        val inflater = activity.layoutInflater
        val mView = inflater.inflate(R.layout.dialog_editdata, null)
        val editText: EditText = mView.findViewById(R.id.text) as EditText
        editText.setText(stringList.get(position).task.toString())
        builder.setView(mView)
                .setPositiveButton("EDIT") { dialog, id ->
                    if (editText.text.toString().isEmpty()) {
                        Toast.makeText(activity, "Message can't be blank!", Toast.LENGTH_SHORT).show()
                        showDialog(position)
                    } else {
                        databaseHandler.updateRecord(editText.text.toString(), stringList[position]._id!!,
                                stringList[position].user_id!!)

                        stringList.clear()
                        stringList.addAll(databaseHandler.getData())
                        notifyDataSetChanged()
                    }
                }
                .setNeutralButton("CANCEL", null)
        builder.create()
        builder.setCancelable(false)
        builder.show()
    }

    override fun getItemCount(): Int {
        return stringList.size
    }
}


