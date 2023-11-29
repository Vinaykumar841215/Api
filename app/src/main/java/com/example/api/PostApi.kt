package com.example.api

//import android.database.Observable
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface PostApi {

    @GET("/posts")

    fun getAllPosts(): Observable<List<ApiModel>>
    companion object Factory {

        fun createRetrofit():PostApi{
            var retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .build()

            return (retrofit.create(PostApi::class.java))
        }
    }

    interface CommentsApi {
        @GET ("comments")

        fun PostAll():Observable<List<CommentsModel>>
        companion object Factory {
            fun createRetrofit():CommentsApi{
                val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("https://jsonplaceholder.typicode.com/")
                    .build()
                return (retrofit.create(CommentsApi::class.java))
            }
        }
    }
    interface AlbumsApi {
        @GET ("albums")

        fun PostAll():Observable<List<AlbumsModel>>
        companion object Factory {
            fun createRetrofil():AlbumsApi{
                val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("https://jsonplaceholder.typicode.com/")
                    .build()

                return (retrofit.create(AlbumsApi::class.java))
            }
        }
    }
    interface imageApi {
        @GET ("photos")

        fun ImageAll():Observable<List<PhotoModel>>
        companion object Factory {
            fun  createRetrofil():imageApi{
                val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("https://jsonplaceholder.typicode.com/")
                    .build()

                return (retrofit.create(imageApi::class.java))
            }
        }
    }
   interface TodosApi {
       @GET ("/todos")

       fun TodosPost():Observable<List<TodosModel>>

       companion object Factroy {
           fun createRetrofil():TodosApi{

               val retrofit = Retrofit.Builder()
                   .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                   .addConverterFactory(GsonConverterFactory.create())
                   .baseUrl("https://jsonplaceholder.typicode.com")
                   .build()

               return (retrofit.create(TodosApi::class.java))
           }
       }
   }
}

