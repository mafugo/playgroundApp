package com.example.playground

import androidx.compose.runtime.Composable

interface ISticker {
    var rotation:Float
    var scale:Float
    var translation:Float
    var transparency:Float

    @Composable
    fun draw() {

    }
}
