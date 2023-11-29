package com.example.api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory

class TodosActivity : AppCompatActivity() {
    lateinit var arrayList: ArrayList<TodosModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todos)

val recyclerView=findViewById<RecyclerView>(R.id.recyclerView)
        arrayList= arrayListOf()


        PostApi.TodosApi.createRetrofil().TodosPost()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(
                {
                    arrayList.addAll(it)
                    recyclerView.adapter=TodosAdapter(this,arrayList)

                    Toast.makeText(this, "Todos Show data", Toast.LENGTH_SHORT).show()
                },
                {
                    Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                }
            )

      }
}