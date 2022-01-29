package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rvTodos = findViewById<RecyclerView>(R.id.rvTodos)
        val btnAddTodo = findViewById<Button>(R.id.btnAddTodo)
        val etTodo = findViewById<EditText>(R.id.etTodo)

        var todoList = mutableListOf(
            Todo("Follow AndroidDevs", false),
            Todo("Follow AndroidDevs", false),
            Todo("Follow AndroidDevs", false),
            Todo("Follow AndroidDevs", false),
            Todo("Follow AndroidDevs", false),
            Todo("Follow AndroidDevs", false),
            Todo("Follow AndroidDevs", false)
        )


        val adapter = TodoAdapter(todoList)
        rvTodos.adapter = adapter
        rvTodos.layoutManager = LinearLayoutManager(this)

        // adding the items to the todo list
        btnAddTodo.setOnClickListener({
            val title = etTodo.text.toString()
            val todo = Todo(title, false)

            todoList.add(todo)
            // to update the adapter
            adapter.notifyItemInserted(todoList.size-1)
        })
    }
}