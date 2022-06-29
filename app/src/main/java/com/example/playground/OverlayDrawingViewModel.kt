package com.example.playground

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class OvarlayDrawingViewModel : ViewModel() {

    val list = MutableLiveData<List<ISticker>?>()
    val translationPosition = MutableLiveData<Float>(0f)
    val rotationPosition =  MutableLiveData<Float>(0f)
    val scalingPositionX = MutableLiveData<Float>(0f)
    val scalingPositionY = MutableLiveData<Float>(0f)

}