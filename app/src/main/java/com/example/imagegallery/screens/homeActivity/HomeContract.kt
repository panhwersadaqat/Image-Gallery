package com.example.imagegallery.screens.homeActivity

/**
 * Created by Sadaqat Panhwer
 * https://panhwersadaqat.github.io/
 * on 8/18/2021
 */
interface HomeContract {
    interface View {
        fun setupViews()
    }

    interface Actions {
        fun initScreen()
    }
}