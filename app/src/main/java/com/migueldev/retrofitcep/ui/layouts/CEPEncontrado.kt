package com.migueldev.retrofitcep.ui.layouts

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.migueldev.retrofitcep.CepViewModel
import com.migueldev.retrofitcep.R
import com.migueldev.retrofitcep.ui.components.CardsCEP
import com.migueldev.retrofitcep.ui.components.LottieAnimation

//Caso a consulta retorne positivamente
@Composable
fun CEPEncontrado(viewModel: CepViewModel){

    val scrollVertical = rememberScrollState()

    //Pega os dados do model pelo ViewModel
    val cepResponse = viewModel.cepInfo.collectAsState()

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(30.dp)
        .verticalScroll(scrollVertical)) {
        Spacer(modifier = Modifier.size(10.dp))
        Text(text = "O CEP Informado pertence a:",
            fontWeight = FontWeight.Bold)
        Row {
            //Nome da cidade
            Text(text = cepResponse.value.localidade,
                style = MaterialTheme.typography.titleLarge)
            Text(text = cepResponse.value.uf,
                style = MaterialTheme.typography.labelSmall)
        }
        Spacer(modifier = Modifier.size(10.dp))
        //Animação de sucesso
        LottieAnimation(animationRes = R.raw.animation_success,
            isPlaying = true,
            Modifier.size(200.dp),
            1)
        Spacer(modifier = Modifier.size(10.dp))

        CardsCEP(campoDoCard = "Logradouro", campoDoViewModel = cepResponse.value.logradouro)
        CardsCEP(campoDoCard = "Complemento", campoDoViewModel = cepResponse.value.complemento)
        CardsCEP(campoDoCard = "Localidade", campoDoViewModel = cepResponse.value.localidade)
        CardsCEP(campoDoCard = "IBGE", campoDoViewModel = cepResponse.value.ibge)
        CardsCEP(campoDoCard = "GIA", campoDoViewModel = cepResponse.value.gia)
        CardsCEP(campoDoCard = "DDD", campoDoViewModel = cepResponse.value.ddd)
        CardsCEP(campoDoCard = "SIAFI", campoDoViewModel = cepResponse.value.siafi)

    }
}
@Composable
fun CEPEncontradoP(){
    val scrollVertical = rememberScrollState()

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(30.dp)
        .verticalScroll(scrollVertical)) {
        Spacer(modifier = Modifier.size(70.dp))
        Text(text = "O CEP Informado pertence a:",
            fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.size(10.dp))
        Row {
            Text(text = "FORTUNA DE MINAS",
                style = MaterialTheme.typography.titleLarge)
            Text(text = "MG",
                style = MaterialTheme.typography.labelSmall)
        }
        Spacer(modifier = Modifier.size(10.dp))
        LottieAnimation(animationRes = R.raw.animation_success,
            isPlaying = true,
            Modifier.size(200.dp),
            1)
        CardsCEP(campoDoCard = "Logradouro", campoDoViewModel = "")
        CardsCEP(campoDoCard = "Complemento", campoDoViewModel = "")
        CardsCEP(campoDoCard = "Localidade", campoDoViewModel = "")
        CardsCEP(campoDoCard = "IBGE", campoDoViewModel = "")
        CardsCEP(campoDoCard = "GIA", campoDoViewModel = "")
        CardsCEP(campoDoCard = "DDD", campoDoViewModel = "")
        CardsCEP(campoDoCard = "SIAFI", campoDoViewModel = "")

    }
}
@Preview(showBackground = true)
@Composable
fun CEPEncontradoPreview(){
    CEPEncontradoP()
}