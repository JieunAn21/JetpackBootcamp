package com.example.recyclerviewdemo1

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    val fruitsList = listOf(
        Fruit("Mango", "Tom"),
        Fruit("Apple", "Joe"),
        Fruit("Banana", "Mark"),
        Fruit("Guava", "Mike"),
        Fruit("Lemon", "Mike"),
        Fruit("Pear", "Frank"),
        Fruit("Orange", "Joe")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myRecyclerView = findViewById<RecyclerView>(R.id.my_recycler_view)
        myRecyclerView.setBackgroundColor(Color.YELLOW)
        myRecyclerView.layoutManager = LinearLayoutManager(this)
        myRecyclerView.adapter = MyRecyclerViewAdapter(fruitsList)
    }
}