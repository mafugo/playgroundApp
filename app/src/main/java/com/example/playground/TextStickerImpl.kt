package com.example.playground

import androidx.compose.runtime.Composable

class TextStickerImpl(

    //TODO Default degerleri burda verelim

    override var rotation: Float,
    override var scale: Float,
    override var translation: Float,
    override var transparency: Float,
    override var text: String,
    override var color: Int,
    override var fontSize: Int,
    override var backgroundColor: Int,

    ) : BaseSticker(), ITextSticker {

    @Composable
    override fun draw() {
        super<ITextSticker>.draw()
    }
}