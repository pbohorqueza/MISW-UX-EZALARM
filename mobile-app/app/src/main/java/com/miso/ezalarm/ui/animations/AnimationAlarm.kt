package com.miso.ezalarm.ui.animations

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.miso.ezalarm.R

@Composable
fun AnimationAlarm(modifier: Modifier = Modifier) {

    val preloaderLottieComposition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(
            R.raw.animation_alarm
        )
    )

    val preloaderProgress by animateLottieCompositionAsState(
        preloaderLottieComposition,
        iterations = LottieConstants.IterateForever,
        isPlaying = true
    )
    Box(contentAlignment = Alignment.Center){
        CircleShape()
        LottieAnimation(
            composition = preloaderLottieComposition,
            progress = { preloaderProgress },
            modifier = modifier
        )
    }
    OvalShape()
}

@Composable
fun OvalShape() {
    Canvas(modifier = Modifier.size(width = 130.dp, height = 24.dp)) {
        drawOval(
            color = Color(0xFFE7E9EB),
            topLeft = androidx.compose.ui.geometry.Offset(0f, 0f),
            size = size
        )
    }
}

@Composable
fun CircleShape() {
    Canvas(
        modifier = Modifier
            .size(width = 150.dp, height = 150.dp)

    ) {

        drawCircle(
            color = Color(0xFFFFFFFF),
            radius = (size.minDimension / 2) - 20
        )
        drawCircle(
            color = Color(0x55CCCCCC),
            radius = size.minDimension / 20,
            style = Stroke(width = 2.dp.toPx())
        )
    }
}