package com.example.imagegallery.networking.responses.model

import com.google.gson.annotations.Expose

/**
 * Created by Sadaqat Panhwer
 *  https://panhwersadaqat.github.io/
 * on 8/18/2021
 */
data class ImageUrlsModel(
    @Expose val raw: String,
    @Expose val full: String,
    @Expose val regular: String,
    @Expose val small: String,
    @Expose val thumb: String
)// : Parcelable
