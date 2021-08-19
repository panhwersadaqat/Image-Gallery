package com.example.imagegallery.networking

import com.example.imagegallery.networking.services.ImageApiService
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Sadaqat Panhwer
 * https://panhwersadaqat.github.io/
 * on 8/18/2021
 */
class NetController  private constructor() {
    private var mRetrofit: Retrofit? = null
    private var okHttpClient: OkHttpClient? = null

    val retrofit: Retrofit

        get() {
            if (mRetrofit == null) {
                val gson = GsonBuilder()
                    .setLenient()
                    .create()

                mRetrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(httpClient)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build()
            }
            return mRetrofit!!
        }
    val httpClient: OkHttpClient?
        get() {
            if (okHttpClient == null) {
                val logging = HttpLoggingInterceptor()
                logging.level = HttpLoggingInterceptor.Level.BODY
                okHttpClient = OkHttpClient.Builder()
                    // val httpClient: OkHttpClient.Builder = OkHttpClient.Builder()
                    .addInterceptor(logging)
                    .addNetworkInterceptor(StethoInterceptor())
                    .build()
            }
            return okHttpClient
        }

    companion object {
        @JvmStatic
        val instance = NetController()
        const val BASE_URL = "https://api.unsplash.com/"
    }
}