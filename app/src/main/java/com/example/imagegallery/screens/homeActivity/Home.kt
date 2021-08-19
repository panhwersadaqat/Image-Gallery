package com.example.imagegallery.screens.homeActivity

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.imagegallery.R
import com.example.imagegallery.base.BaseActivity
import com.example.imagegallery.databinding.ActivityHomeBinding
import com.example.imagegallery.databinding.ImgItemBinding
import com.example.imagegallery.networking.responses.model.ImageModel
import com.example.imagegallery.networking.services.ApiListener
import com.example.imagegallery.utils.showToast
import com.thetechnocafe.gurleensethi.liteutils.RecyclerAdapterUtil


class Home : BaseActivity(), HomeContract.View, ApiListener {
    var bi: ActivityHomeBinding? = null
    var presenter: HomePresenter? = null
    private var imageAdapter: RecyclerAdapterUtil<ImageModel>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bi = DataBindingUtil.setContentView(this, R.layout.activity_home)
        bi!!.setView(this)
        presenter = HomePresenter(this)
        presenter!!.initScreen()

    }

    override fun setupViews() {
        //showLoader()
        presenter!!.image(this)

    }

    override fun success(strApiName: String?, response: Any?) {
        // hideLoader()
        showToast(this,"Success")
        val data: List<ImageModel> = response as List<ImageModel>
        getList(data)
        imageAdapter!!.notifyDataSetChanged()
    }

    override fun error(strApiName: String?, error: String?) {
        showToast(this,"error")
    }

    override fun failure(strApiName: String?, message: String?) {
        showToast(this, "${message}")
    }

    fun getList(list: List<ImageModel>) {

        imageAdapter = RecyclerAdapterUtil(applicationContext, list, R.layout.img_item)
        imageAdapter!!.addOnDataBindListener { view: View?, imageModel: ImageModel, integer: Int?, integerMap: Map<Int, View> ->
            val binding: ImgItemBinding = DataBindingUtil.bind(view!!)!!
            binding.executePendingBindings()
            Glide.with(this).load(imageModel.urls.small)
                    .placeholder(R.drawable.ic_loading)
                    .error(R.drawable.ic_loading)
                    .into(binding.itmImg)
            bi!!.rvImages.layoutManager =
                    LinearLayoutManager(applicationContext, RecyclerView.VERTICAL, false)
            bi!!.rvImages.adapter = imageAdapter
        }
    }
}