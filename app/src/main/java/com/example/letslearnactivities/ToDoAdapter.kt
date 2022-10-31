package com.example.letslearnactivities

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ToDoAdapter (
    var todos : List<Todo>
        ) : RecyclerView.Adapter<ToDoAdapter.ToDoViewHolder>(){

    inner class ToDoViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.todo_item,parent,false)
        return ToDoViewHolder(view)
    }

    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int) {
        holder.itemView.apply {
            val text : TextView = findViewById(R.id.tvTitle)
            text.text = todos[position].title
            val check : CheckBox = findViewById(R.id.Done)
            check.isChecked = todos[position].isChecked
        }
    }

    override fun getItemCount(): Int {
        return todos.size
    }

}