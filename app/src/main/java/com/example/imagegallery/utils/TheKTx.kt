package com.example.imagegallery.utils

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.swiperefreshlayout.widget.CircularProgressDrawable

/**
 * Created by Sadaqat Panhwer
 *  https://panhwersadaqat.github.io/
 * on 8/18/2021
 */

fun showToast(context: Context,message: String) {
    Toast.makeText(context,message, Toast.LENGTH_SHORT).show()
}

