package com.example.imagegallery.networking.services

/**
 * Created by Sadaqat Panhwer
 * https://panhwersadaqat.github.io/
 * on 8/18/2021
 */
interface ApiListener {
    fun success(strApiName: String?, response: Any?)
    fun error(strApiName: String?, error: String?)
    fun failure(strApiName: String?, message: String?)
}