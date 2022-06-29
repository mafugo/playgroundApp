package com.example.playground

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel: ViewModel() {
    val translationPosition = MutableLiveData<Float>(0f)
    val rotationPosition =  MutableLiveData<Float>(0f)
    val scalingPositionX = MutableLiveData<Float>(0f)
    val scalingPositionY = MutableLiveData<Float>(0f)


    @Composable
    fun imageGetter(imageValue: Int): ImageBitmap {
        val image = ImageBitmap.imageResource(imageValue)
        return image
    }



}
