package com.migueldev.retrofitcep.ui.layouts

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.migueldev.retrofitcep.R
import com.migueldev.retrofitcep.ui.components.ResultAnimation

//Caso dê erro na busca
@Composable
fun ErroNaBusca(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        Spacer(modifier = Modifier.size(50.dp))
        ResultAnimation(animationRes = R.raw.animation_error,
            isPlaying = true,
            Modifier.size(200.dp)
        )
        Spacer(modifier = Modifier.size(200.dp))
        Text(text = "Falha na Busca",
            style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.size(20.dp))
        Text(text = "Verifique a ortografia, ou tente novamente mais tarde")
    }
}