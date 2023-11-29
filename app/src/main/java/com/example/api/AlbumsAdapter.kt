package com.example.api

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AlbumsAdapter(val context: Context,val data:ArrayList<AlbumsModel>):RecyclerView.Adapter<AlbumsAdapter.MyHolderView>() {

    class MyHolderView(itemView:View):RecyclerView.ViewHolder(itemView){

        val userId = itemView.findViewById<TextView>(R.id.userId)
        val id= itemView.findViewById<TextView>(R.id.id)
        val title = itemView.findViewById<TextView>(R.id.title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolderView {
        val layout = LayoutInflater.from(context).inflate(R.layout.albums_item,parent,false)
        return MyHolderView(layout)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MyHolderView, position: Int) {
        holder.userId.text ="UserID :- " +data[position].userId.toString()
        holder.id.text ="ID :- " +data[position].id.toString()
        holder.title.text = "TITLE :- " +data[position].title
    }
}