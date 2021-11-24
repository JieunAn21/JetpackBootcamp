package com.example.retrofitdemo

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var retService: AlbumService

    lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        retService = RetrofitInstance.getRetrofitInstance().create(AlbumService::class.java)

        textView = findViewById(R.id.text_view)

        //getRequestWithQueryParameters()
        //getRequestWithPathParameters()
        uploadAlbum()
    }

    private fun getRequestWithQueryParameters() {
        val responseLiveData: LiveData<Response<Albums>> = liveData {
            val response = retService.getSortedAlbums(3)
            emit(response)
        }

        responseLiveData.observe(this, {
            val albumsList = it.body()?.listIterator()
            if (albumsList != null) {
                while (albumsList.hasNext()) {
                    val albumsItem = albumsList.next()
                    val result = " " + "Album Title : ${albumsItem.title}" + "\n" +
                            " " + "Album Id : ${albumsItem.id}" + "\n" +
                            " " + "User Id : ${albumsItem.userId}" + "\n\n\n"

                    textView.append(result)
                }
            }
        })
    }

    private fun getRequestWithPathParameters() {
        //path parameter example
        val pathResponse: LiveData<Response<AlbumsItem>> = liveData {
            val response = retService.getAlbum(3)
            emit(response)
        }

        pathResponse.observe(this, {
            val title = it.body()?.title
            Toast.makeText(applicationContext, title, Toast.LENGTH_LONG).show()
        })
    }

    private fun uploadAlbum() {
        val album = AlbumsItem(0, "My title", 3) // 여기에 적은 id는 무시되고 서버에서 새로운 id를 할당한다.

        val postResponse: LiveData<Response<AlbumsItem>> = liveData {
            val response = retService.uploadAlbum(album)
            emit(response)
        }

        postResponse.observe(this, {
            val receivedAlbumsItem = it.body()
            val result = " " + "Album Title : ${receivedAlbumsItem?.title}" + "\n" +
                    " " + "Album Id : ${receivedAlbumsItem?.id}" + "\n" +
                    " " + "User Id : ${receivedAlbumsItem?.userId}" + "\n\n\n"

            textView.text = result
        })
    }
}