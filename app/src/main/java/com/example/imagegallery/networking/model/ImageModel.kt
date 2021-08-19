package com.example.imagegallery.networking.model

import com.google.gson.annotations.Expose

/**
 * Created by Sadaqat Panhwer
 *  https://panhwersadaqat.github.io/
 * on 8/18/2021
 */
data class ImageModel(
    @Expose val id: String,
    @Expose val created_at: String,
    @Expose val color: String,
    @Expose val description: String,
    @Expose val urls: ImageUrlsModel,
    @Expose val user: UserModel
)
