package com.example.playground

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.lifecycle.ViewModel

class ImageStickerImplViewModel: ViewModel() {

    @Composable
    fun imageGetter(imageValue: Int): ImageBitmap {
        val image = ImageBitmap.imageResource(imageValue)
        return image
    }
}