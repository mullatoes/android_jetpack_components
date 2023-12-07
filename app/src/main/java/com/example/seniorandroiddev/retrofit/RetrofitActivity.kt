package com.example.seniorandroiddev.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.seniorandroiddev.R
import com.example.seniorandroiddev.databinding.ActivityRetrofitBinding
import com.example.seniorandroiddev.retrofit.service.AlbumService
import retrofit2.Response

class RetrofitActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRetrofitBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_retrofit)

        val retrofitService =
            RetrofitInstance
                .getRetrofitInstance()
                .create(AlbumService::class.java)

        val responseLiveData: LiveData<Response<Album>> =
            liveData {
                val response = retrofitService.getAlbums()
                emit(response)
            }

        responseLiveData.observe(this) {
            val albumList = it.body()?.listIterator()

            if (albumList != null) {
                while (albumList.hasNext()) {
                    val album = albumList.next()

                    Log.i("ALBUMS", "Title ${album.title}")

                    val data = "Title ${album.title} " + "\n" +
                            "Id ${album.id}" + "\n" +
                            "User Id ${album.userId}" + "\n\n\n"

                    binding.textViewAlbumData.append(data)

                }
            }
        }
    }
}