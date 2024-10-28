package com.migueldev.retrofitcep.ui.layouts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.abdullahalhakimi.smoothmotion.animations.LoadingDotsAnimation

@Composable
fun LoadingLayout(){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        LoadingDotsAnimation(
            circleSize = 20.dp,
            spaceBetween = 10.dp,
            travelDistance = 15.dp,
            circleColor = MaterialTheme.colorScheme.primary
        )
    }
}