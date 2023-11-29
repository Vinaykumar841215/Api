package com.example.api

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class PhotoAdapter(val context: Context , val imageData:ArrayList<PhotoModel>):RecyclerView.Adapter<PhotoAdapter. MyHolderView>() {

    class  MyHolderView(itemView:View):RecyclerView.ViewHolder(itemView){

        val image = itemView.findViewById<ImageView>(R.id.image)
        val image1 = itemView.findViewById<ImageView>(R.id.image1)
         val albumId = itemView.findViewById<TextView>(R.id.albumId)
        val id = itemView.findViewById<TextView>(R.id.id)
        val title = itemView.findViewById<TextView>(R.id.title)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolderView {
        val layout = LayoutInflater.from(context).inflate(R.layout.photo_item,parent,false)

        return MyHolderView(layout)
    }

    override fun getItemCount(): Int {
        return imageData.size
    }

    override fun onBindViewHolder(holder: MyHolderView, position: Int) {

        Glide.with(context).load (imageData[position].url).into(holder.image)
        Glide.with(context).load (imageData[position].url).into(holder.image1)
        holder.albumId.text ="AlbumId :- " +imageData[position].albumId.toString()
        holder.id.text= "ID :- " + imageData[position].id.toString()
        holder.title.text = "TITLE :- " +imageData[position].title

    }
}