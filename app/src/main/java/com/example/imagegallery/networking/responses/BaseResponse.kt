package com.example.imagegallery.networking.responses

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Sadaqat Panhwer
 * https://panhwersadaqat.github.io/
 * on 8/18/2021
 */
class BaseResponse<T> {
    @Expose
    @SerializedName("message")
    var message: String? = null

    @Expose
    @SerializedName("status")
    var status: String? = null

    @Expose
    @SerializedName("data")
    var data: T? = null
}