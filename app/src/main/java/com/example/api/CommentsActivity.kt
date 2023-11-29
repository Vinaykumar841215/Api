package com.example.api

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class CommentsActivity : AppCompatActivity() {
    lateinit var arrayList: ArrayList<CommentsModel>
    lateinit var recyclerView: RecyclerView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comments)

        recyclerView = findViewById(R.id.recyclerView)
        arrayList = arrayListOf()

      PostApi.CommentsApi.createRetrofit().PostAll()
          .observeOn(AndroidSchedulers.mainThread())
          .subscribeOn(Schedulers.io())
          .subscribe({
              arrayList.addAll(it)
              recyclerView.adapter=CommentsAdapter(this,arrayList)

              Toast.makeText(this, "Comment Data show", Toast.LENGTH_SHORT).show()
          },{
              Toast.makeText(this,it.message, Toast.LENGTH_SHORT).show()
          }
          )
        val Btn_next = findViewById<Button>(R.id.Btn_next)
        Btn_next.setOnClickListener {
            val intent  = Intent(this,AlbumsActivity::class.java)
            startActivity(intent)
        }

    }
}