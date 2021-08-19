package com.example.imagegallery.networking.responses.model

import com.google.gson.annotations.Expose

/**
 * Created by Sadaqat Panhwer
 *  https://panhwersadaqat.github.io/
 * on 8/18/2021
 */
data class UserModel(
    @Expose val id: String,
    @Expose val username: String,
    @Expose val name: String
) //: Parcelable

