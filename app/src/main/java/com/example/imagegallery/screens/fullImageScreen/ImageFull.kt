package com.example.imagegallery.screens.fullImageScreen

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.example.imagegallery.R
import com.example.imagegallery.base.BaseActivity
import com.example.imagegallery.databinding.ActivityImageDetailBinding


class ImageFull : BaseActivity(), ImageFullContract.View {
    var bi: ActivityImageDetailBinding? = null
    var presenter: ImageFullPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bi = DataBindingUtil.setContentView(this, R.layout.activity_image_detail)
        bi!!.setView(this)
        presenter = ImageFullPresenter(this)
        presenter!!.initScreen()

    }

    override fun setupViews() {
        val extras = intent.extras
        if (extras != null){
            var data = extras!!.getString("url")
            Glide.with(this).load(data)
                .into(bi!!.fullImgVew)
        }
    }
}