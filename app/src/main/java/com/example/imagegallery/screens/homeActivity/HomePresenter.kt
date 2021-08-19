package com.example.imagegallery.screens.homeActivity

import com.example.imagegallery.base.BasePresenter
import com.example.imagegallery.networking.NetController
import com.example.imagegallery.networking.services.APIResponse
import com.example.imagegallery.networking.services.ApiListener
import com.example.imagegallery.networking.services.ImageApiService


/**
 * Created by Sadaqat Panhwer
 *  https://panhwersadaqat.github.io/
 * on 8/18/2021
 */
class HomePresenter(view: HomeContract.View?) :
    BasePresenter<HomeContract.View?>(view), HomeContract.Actions {
    override fun initScreen() {
        _view!!.setupViews()
    }

    fun image(apiListener: ApiListener){
        val apiService = NetController.instance.retrofit.create(ImageApiService::class.java)
        var call = apiService.loadPhotos("Client-ID kqaYOsy5jjtdfagxH7MIopkybYypkcyyK-qSCY4M3XY",2,30,"popular")
        APIResponse.callRetrofit(call, "photos", apiListener)

    }
}