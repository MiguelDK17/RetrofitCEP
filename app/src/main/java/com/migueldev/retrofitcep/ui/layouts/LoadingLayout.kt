package com.migueldev.retrofitcep.ui.layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abdullahalhakimi.smoothmotion.animations.LoadingDotsAnimation
import com.airbnb.lottie.compose.LottieConstants
import com.migueldev.retrofitcep.R
import com.migueldev.retrofitcep.ui.components.LottieAnimation

@Composable
fun LoadingLayout(){

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LottieAnimation(animationRes = R.raw.animation_search,
            isPlaying = true,
            interations = LottieConstants.IterateForever,
            modifier = Modifier.fillMaxSize())
        LoadingDotsAnimation(
            circleSize = 20.dp,
            spaceBetween = 10.dp,
            travelDistance = 15.dp,
            circleColor = MaterialTheme.colorScheme.primary
        )
    }
}
@Composable
@Preview(showBackground = true)
private fun Preview(){
    LoadingLayout()
}