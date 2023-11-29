package com.example.api

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TodosAdapter(val context: Context , val DataTodos:ArrayList<TodosModel>):RecyclerView.Adapter<TodosAdapter.MyHolderView>() {
    class MyHolderView(itemView: View):RecyclerView.ViewHolder(itemView){

        val userId = itemView.findViewById<TextView>(R.id.userId)
        val id = itemView.findViewById<TextView>(R.id.id)
        val title = itemView.findViewById<TextView>(R.id.title)
        val completed = itemView.findViewById<TextView>(R.id.completed)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolderView {
        val layout = LayoutInflater.from(context).inflate(R.layout.todos_item,parent,false)

        return MyHolderView(layout)
    }

    override fun getItemCount(): Int {
        return DataTodos.size
    }

    override fun onBindViewHolder(holder: MyHolderView, position: Int) {
        holder.userId.text ="UserID :- " +DataTodos[position].userId.toString()
        holder.id.text = "ID :- " + DataTodos[position].id.toString()
        holder.title.text = "TITLE :- " + DataTodos[position].title
        holder.completed.text = "Completed :- " +DataTodos[position].completed
    }
}