package com.migueldev.retrofitcep.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition

//Função de animação com lottie
@Composable
fun ResultAnimation(
    animationRes: Int,
    isPlaying: Boolean,
    modifier: Modifier = Modifier
){
    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(animationRes))

    val progress by animateLottieCompositionAsState(
        composition = composition, //Composição da animação
        isPlaying = isPlaying, //Estado da animação, se está tocando ou não
        iterations = 1) //Toca apenas uma vez

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LottieAnimation(composition = composition,
            progress = progress,
            modifier = modifier
        )

    }
}
