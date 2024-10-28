package com.migueldev.retrofitcep.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CardsCEP(campoDoCard: String, campoDoViewModel: String){
    OutlinedCard(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp),
    ) {
        Row(
            Modifier
                .padding(10.dp)
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "$campoDoCard:",
                style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.size(5.dp))
            Text(text = campoDoViewModel,
                style = MaterialTheme.typography.bodyLarge)
        }
    }
    //Adiciona um espaço por padrão entre os Cards
    Spacer(modifier = Modifier.size(20.dp))
}
@Preview(showBackground = true)
@Composable
fun CardsCEPPreview(){
    CardsCEP("Logradouro", "Fortuna de Minas")
}
