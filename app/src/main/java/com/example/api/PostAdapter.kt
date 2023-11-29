package com.example.api

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PostAdapter(val context: Context,val DataPost:ArrayList<ApiModel>):RecyclerView.Adapter<PostAdapter.MyHolderView>() {
    class MyHolderView(itemView: View):RecyclerView.ViewHolder(itemView){

        val userId = itemView.findViewById<TextView>(R.id.userId)
        val id = itemView.findViewById<TextView>(R.id.id)
        val title = itemView.findViewById<TextView>(R.id.title)
        val body = itemView.findViewById<TextView>(R.id.body)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolderView {
       val layout = LayoutInflater.from(context).inflate(R.layout.list_post,parent,false)
        return MyHolderView(layout)
    }

    override fun getItemCount(): Int {
       return DataPost.size
    }

    override fun onBindViewHolder(holder: MyHolderView, position: Int) {
        holder.userId.text="UserID :- " + DataPost [position].userId
        holder.id.text="ID :- " + DataPost[position].id
        holder.title.text= "TITLE :- "  + DataPost[position].title
        holder.body.text ="BODY :- " + DataPost[position].body
    }
}