package com.example.playground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Slider
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.drawscope.DrawScope.Companion.DefaultBlendMode
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import com.example.playground.ui.theme.PlaygroundTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
            PlaygroundTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    WithTransformFun(viewModel = viewModel)
                }
            }
        }
    }
}

@Composable
fun WithTransformFun(viewModel: MainActivityViewModel) {



    Column {

        Text(text = "translation ${viewModel.translationPosition.value}")
        Spacer(modifier = Modifier.height(4.dp))
        Slider(
            value = viewModel.translationPosition.value!!,
            onValueChange = { viewModel.translationPosition.value = it },
            valueRange = -500f..500f
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(text = "rotation ${viewModel.rotationPosition.value}")
        Spacer(modifier = Modifier.height(4.dp))
        Slider(
            value = viewModel.rotationPosition.value!!,
            onValueChange = { viewModel.rotationPosition.value = it },
            valueRange = 0f..360f
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(text = "scaling X ${viewModel.scalingPositionX.value}")
        Spacer(modifier = Modifier.height(4.dp))
        Slider(
            value = viewModel.scalingPositionX.value!!,
            onValueChange = { viewModel.scalingPositionX.value = it },
            valueRange = 1f..5f
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(text = "scaling Y  ${viewModel.scalingPositionY.value}")
        Spacer(modifier = Modifier.height(4.dp))
        Slider(
            value = viewModel.scalingPositionY.value!!,
            onValueChange = { viewModel.scalingPositionY.value = it },
            valueRange = 1f..5f
        )

        Spacer(modifier = Modifier.height(8.dp))
        val image = viewModel.imageGetter(imageValue = R.drawable.smiling_face_emoji)

        Canvas(modifier = Modifier.fillMaxSize()) {
            val canvasSize = size
            val canvasWidth = size.width
            val canvasHeight = size.height
            withTransform({
                translate(left = viewModel.translationPosition.value!!)
                rotate(degrees = viewModel.rotationPosition.value!!, Offset(x = (image.width/2).toFloat(),
                    y = (image.height/2).toFloat()))
                scale(viewModel.scalingPositionX.value!!, viewModel.scalingPositionY.value!!)
                //translate(canvasWidth / 20F)
            }) {

                /*drawRect(
                    color = Color.Gray,
                    topLeft = Offset(x = canvasWidth / 3F, y = canvasHeight / 3F),
                    size = canvasSize / 3F
                )*/

                drawImage(image, Offset.Zero, 1.0f, Fill, null, DefaultBlendMode)

            }
        }
    }


}

@Preview
@Composable
fun PreviewWithTransform() {

    PlaygroundTheme() {
        val viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        WithTransformFun(viewModel = viewModel)
    }
}