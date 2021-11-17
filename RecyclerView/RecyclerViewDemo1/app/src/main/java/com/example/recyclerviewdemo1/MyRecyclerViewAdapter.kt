package com.example.recyclerviewdemo1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyRecyclerViewAdapter(val fruitsList: List<Fruit>) : RecyclerView.Adapter<MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem = layoutInflater.inflate(R.layout.list_item, parent, false)
        return MyViewHolder(listItem)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val fruit = fruitsList[position]
        val nameTextView = holder.view.findViewById<TextView>(R.id.name_text_view)
        nameTextView.text = fruit.name
    }

    override fun getItemCount(): Int {
        return fruitsList.size
    }
}

class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

}