package com.example.imagegallery.networking.services

import com.example.imagegallery.networking.model.ImageModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query


/**
 * Created by Sadaqat Panhwer
 *  https://panhwersadaqat.github.io/
 * on 8/18/2021
 */
interface ImageApiService {

    @GET("photos")
    fun loadPhotos(
        @Header("Authorization") token : String = "",
        @Query("page") page: Int = 1,
        @Query("per_page") numOfPhotos: Int = 10,
        @Query("order_by") orderBy: String = "popular"
    ): Call<List<ImageModel>>

}