package com.example.seniorandroiddev.retrofit.service

import com.example.seniorandroiddev.retrofit.Album
import com.example.seniorandroiddev.retrofit.AlbumItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AlbumService {

    @GET("/albums")
    suspend fun getAlbums(): Response<Album>

    @GET("/albums")
    suspend fun getSortedAlbums(
        @Query("userId") userId: Int
    ): Response<Album>

    @GET("/albums/{id}")
    suspend fun getAlbum(
        @Path(
            value = "id"
        ) albumId: Int
    ): Response<AlbumItem>

}