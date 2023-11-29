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

class AlbumsActivity : AppCompatActivity() {
    lateinit var arrayList: ArrayList<AlbumsModel>
    lateinit var recyclerView: RecyclerView
     @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_albums)

        recyclerView = findViewById(R.id.recyclerView)
        arrayList = arrayListOf()

        PostApi.AlbumsApi.createRetrofil().PostAll()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({
                arrayList.addAll(it)
                recyclerView.adapter=AlbumsAdapter(this,arrayList)
                Toast.makeText(this, "Show Album Data", Toast.LENGTH_SHORT).show()

            },{
                Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
            }
            )
        val imageBtn = findViewById<Button>(R.id.imageBtn)

        imageBtn.setOnClickListener {
            val intent = Intent(this,PhotoActivity::class.java)
            startActivity(intent)
        }

    }
}