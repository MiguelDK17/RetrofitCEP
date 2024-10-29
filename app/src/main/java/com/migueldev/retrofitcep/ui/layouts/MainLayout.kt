package com.migueldev.retrofitcep.ui.layouts

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieConstants
import com.migueldev.retrofitcep.CepViewModel
import com.migueldev.retrofitcep.CepVisualTransformation
import com.migueldev.retrofitcep.R
import com.migueldev.retrofitcep.ui.components.LottieAnimation

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainLayout(viewModel: CepViewModel){
    var cep by remember {
        mutableStateOf("")
    }
    val isCepValid = cep.length == 8
    val cancel = painterResource(id = R.drawable.baseline_cancel_24)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        LottieAnimation(
            animationRes = R.raw.animation_man_walking,
            isPlaying = true,
            interations = LottieConstants.IterateForever,
            modifier = Modifier.size(200.dp))
        Spacer(modifier = Modifier.size(20.dp))
        ElevatedCard(
            modifier = Modifier
                .fillMaxWidth(),

        ) {
            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally) {

                Spacer(modifier = Modifier.size(50.dp))

                Text(text = "Olá, Bem Vindo ao RetrofitCEP !!!",
                    style = MaterialTheme.typography.titleLarge)

                Spacer(modifier = Modifier.size(35.dp))

                Text(text = "Por favor, insira seu CEP:",
                    fontWeight = FontWeight.Bold)

                Spacer(modifier = Modifier.size(30.dp))

                OutlinedTextField(value = cep,
                    onValueChange = { value ->
                    if (value.length <= 8) cep = value

                },
                    label = {
                        Text(text = "CEP",
                            color = if (cep.length < 8) Color.Red else Color.Green
                        )
                    },
                    isError = cep.isNotEmpty() && !isCepValid, //Ativa o modo de erro caso o CEP não seja válido
                    trailingIcon = {

                       if (isCepValid){
                           //Ativa o ícone de Check quando o CEP tem 8 digitos
                           Icon(imageVector = Icons.Default.Check,
                               contentDescription = "CEP Válido",
                               tint = Color.Green)
                       }
                    },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        //Define a cor das bordas e dor cursor, alternado entre verde e vermelho dependendo da validade do CEP
                        focusedBorderColor = if (isCepValid) Color.Green else Color.Red,
                        unfocusedBorderColor = if (isCepValid) Color.Green else Color.Red,
                        cursorColor = if (isCepValid) Color.Green else Color.Red
                    ),
                    visualTransformation = CepVisualTransformation())
                Spacer(modifier = Modifier.size(200.dp))
                Button(onClick = {
                    viewModel.searchCep(cep)
                }) {
                    Text(text = "Buscar CEP")
                }
            }
        }

    }

}
@Composable
fun MainLayoutP(){
    var text by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        LottieAnimation(
            animationRes = R.raw.animation_man_walking,
            isPlaying = true,
            interations = LottieConstants.IterateForever,
            modifier = Modifier.size(200.dp))
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
        Button(onClick = {

        }) {
            Text(text = "Buscar CEP")
        }

    }

}

@Composable
@Preview(showBackground = true)
private fun Preview(){
    MainLayoutP()
}