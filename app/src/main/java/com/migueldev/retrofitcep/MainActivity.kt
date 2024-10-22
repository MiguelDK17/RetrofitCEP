package com.migueldev.retrofitcep

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.integerResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abdullahalhakimi.smoothmotion.animations.LoadingDotsAnimation
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.migueldev.retrofitcep.ui.theme.RetrofitCEPTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RetrofitCEPTheme {
                Scaffold( modifier = Modifier.fillMaxSize() ) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}
@Composable
fun MainLayout(){
    var text by remember {
        mutableStateOf("")
    }
    Column(
    modifier = Modifier
        .fillMaxSize()
        .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Spacer(modifier = Modifier.size(100.dp))
        Text(text = "Olá, Bem Vindo ao RetrofitCEP !!!",
            style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.size(35.dp))
        Text(text = "Por favor, insira seu CEP:",
            fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.size(30.dp))
        OutlinedTextField(value = text, onValueChange = { value ->
            text = value
        },
            label = {
                Text(text = "CEP")
            })
        Spacer(modifier = Modifier.size(200.dp))
        Button(onClick = {  }) {
            Text(text = "Buscar CEP")
        }

    }

}
@Composable
fun Loading(){
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
@Composable
fun CEPEncontrado(){
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(30.dp)) {
        Spacer(modifier = Modifier.size(70.dp))
        Text(text = "O CEP Informado pertence a:",
            fontWeight = FontWeight.Bold)
        Row {
            Text(text = "FORTUNA DE MINAS",
                style = MaterialTheme.typography.titleLarge)
            Text(text = "MG",
                style = MaterialTheme.typography.labelSmall)
        }
        ResultAnimation(animationRes = R.raw.animation_success,
            isPlaying = true,
            Modifier.size(200.dp))
        Text(text = "Logradouro")
        Text(text = "Complemento")
        Text(text = "Localidade")
        Text(text = "IBGE")
        Text(text = "GIA")
        Text(text = "DDD")
        Text(text = "SIAFI")

    }
}
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
@Composable
fun ResultAnimation(
    animationRes: Int,
    isPlaying: Boolean,
    modifier: Modifier = Modifier
){
    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(animationRes))

    val progress by animateLottieCompositionAsState(
        composition = composition,
        isPlaying = isPlaying,
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



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RetrofitCEPTheme {
        CEPEncontrado()
    }
}