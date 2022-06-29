package com.example.playground

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.compose.ui.layout.ContentScale
import androidx.lifecycle.ViewModelProvider
import com.skydoves.landscapist.glide.GlideImage

class ImageStickerImpl(
    override var imageUrl: String,
    override var rotation: Float,
    override var scale: Float,
    override var translation: Float,
    override var transparency: Float
) : BaseSticker(), IImageSticker{
    @Composable
    override fun draw() {
        val viewModel = ViewModelProvider(MainActivity()).get(ImageStickerImplViewModel::class.java)
        val image = viewModel.imageGetter(imageValue = R.drawable.smiling_face_emoji)
        val imageErr = viewModel.imageGetter(imageValue = R.drawable.smiling_face_emoji)

        val glideImage = GlideImage(
            imageModel = imageUrl,
            // Crop, Fit, Inside, FillHeight, FillWidth, None
            contentScale = ContentScale.Crop,
            // shows a placeholder while loading the image.
            placeHolder = image ,
            // shows an error ImageBitmap when the request failed.
            error = imageErr
        )
        Canvas(modifier = Modifier.fillMaxSize()){
            withTransform({
                translate(left = translation)
                rotate(degrees = rotation)

            }) {
                //Image(painterresource(imageUri))
                glideImage
            }

        }

    }

}