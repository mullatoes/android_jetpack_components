package com.example.seniorandroiddev.retrofit.service

import com.example.seniorandroiddev.retrofit.Album
import retrofit2.Response
import retrofit2.http.GET

interface AlbumService {


    @GET("/albums")
    suspend fun getAlbums() : Response<Album>




}