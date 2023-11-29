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

class PhotoActivity : AppCompatActivity() {
    lateinit var arrayList: ArrayList<PhotoModel>
    lateinit var recyclerView: RecyclerView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo)

       recyclerView = findViewById(R.id.recyclerView)
        arrayList = arrayListOf()

        PostApi.imageApi.createRetrofil().ImageAll()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({

                arrayList.addAll(it)
                recyclerView.adapter = PhotoAdapter(this,arrayList)

                Toast.makeText(this, "show data", Toast.LENGTH_SHORT).show()
            },{
                Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
            })

        val Btn_next = findViewById<Button>(R.id.NextBtn)
        Btn_next.setOnClickListener {
            startActivity(Intent(this,TodosActivity::class.java))
        }

    }
}