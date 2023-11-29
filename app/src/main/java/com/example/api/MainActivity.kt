package com.example.api

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {


    lateinit var array:ArrayList<ApiModel>
    lateinit var recyclerView: RecyclerView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        array = arrayListOf()

        PostApi.createRetrofit().getAllPosts()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({
             array.addAll(it)
                recyclerView.adapter=PostAdapter(this,array)

                Toast.makeText(this, "show Post", Toast.LENGTH_SHORT).show()
            },{
                Toast.makeText(this, it.toString(), Toast.LENGTH_SHORT).show()
            }
            )

        val nextBtn = findViewById<Button>(R.id.nextBtn)
        nextBtn.setOnClickListener {

            val intent = Intent(this, CommentsActivity::class.java)
            startActivity(intent)
        }

    }
}