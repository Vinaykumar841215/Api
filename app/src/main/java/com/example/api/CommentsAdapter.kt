package com.example.api

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CommentsAdapter(val context: Context, val dataPost:ArrayList<CommentsModel>):RecyclerView.Adapter<CommentsAdapter.MyHolderView>() {

    class MyHolderView(itemView: View):RecyclerView.ViewHolder(itemView){

        val postId = itemView.findViewById<TextView>(R.id.postId)
        val id = itemView.findViewById<TextView>(R.id.id)
        val name = itemView.findViewById<TextView>(R.id.name)
        val email = itemView.findViewById<TextView>(R.id.email)
//        val body = itemView.findViewById<TextView>(R.id.body)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolderView {
        val layout = LayoutInflater.from(context).inflate(R.layout.comments_item,parent,false)
        return MyHolderView(layout)
    }

    override fun getItemCount(): Int {
        return dataPost.size
    }

    override fun onBindViewHolder(holder: MyHolderView, position: Int) {
        holder.postId.text ="POST_ID :- " + dataPost[position].postId.toString()
        holder.id.text ="ID :- " + dataPost[position].id.toString()
        holder.name.text="NAME :- " + dataPost[position].name
        holder.email.text ="EMAIL :- " +dataPost[position].email
//        holder.body.text ="BODY :- " + dataPost[position].body


    }
}