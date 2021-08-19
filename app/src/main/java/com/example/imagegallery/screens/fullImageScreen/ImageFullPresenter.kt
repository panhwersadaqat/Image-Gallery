package com.example.imagegallery.screens.fullImageScreen

import com.example.imagegallery.base.BasePresenter

/**
 * Created by Sadaqat Panhwer
 *  https://panhwersadaqat.github.io/
 * on 8/19/2021
 */
class ImageFullPresenter (view: ImageFullContract.View?) :
    BasePresenter<ImageFullContract.View?>(view), ImageFullContract.Actions {
    override fun initScreen() {
        _view!!.setupViews()
    }

}