package com.migueldev.retrofitcep.ui.layouts

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.migueldev.retrofitcep.CepViewModel
import com.migueldev.retrofitcep.SearchState

@Composable
fun MainLayout(viewModel: CepViewModel){
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
        Button(onClick = {
            viewModel.searchCep(text)
        }) {
            Text(text = "Buscar CEP")
        }

    }

}