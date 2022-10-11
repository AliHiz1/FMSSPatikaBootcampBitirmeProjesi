package com.example.fmsspatikabitirme.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

fun ImageView.apiDownloadFromUrl(url: String?){
    url.let {
        Glide.with(context)
            .load(url)
            .centerCrop()
            .into(this)
    }
}

@BindingAdapter("android:loadImage")
fun downloadImage(view: ImageView,url: String?){
    view.apiDownloadFromUrl(url)
}