package com.example.letslearnactivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ForthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forth)


        var todoList = mutableListOf(
            Todo("Kill Yourself",false),
            Todo("Have Fun",true),
            Todo("Develop An App",false),
            Todo("Play Guitar",false),
            Todo("Watch Tv",false),
            Todo("Go To Sleep",false)
        )

        val adapter = ToDoAdapter(todoList)
        val recycle : RecyclerView = findViewById(R.id.rvTodo)
        recycle.adapter = adapter
        recycle.layoutManager = LinearLayoutManager(this)

        val button : Button = findViewById(R.id.toDoButton)
        button.setOnClickListener{
            val text : TextView = findViewById(R.id.etTodo)
            val Todo = Todo(text.text.toString(),false)
            todoList.add(Todo)
            adapter.notifyItemInserted(todoList.size-1)
            text.text = ""
        }

        val button2 : Button = findViewById(R.id.button2)
        button2.setOnClickListener{
            Intent(this,FifthActivity::class.java).also {
                startActivity(it)
            }
        }

    }
}