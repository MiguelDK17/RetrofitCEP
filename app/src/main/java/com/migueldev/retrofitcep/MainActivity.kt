package com.migueldev.retrofitcep

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.migueldev.retrofitcep.ui.layouts.CEPEncontrado
import com.migueldev.retrofitcep.ui.layouts.ErroNaBusca
import com.migueldev.retrofitcep.ui.layouts.LoadingLayout
import com.migueldev.retrofitcep.ui.layouts.MainLayout
import com.migueldev.retrofitcep.ui.theme.RetrofitCEPTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    val viewModel by viewModels<CepViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RetrofitCEPTheme {
                Surface( modifier = Modifier.fillMaxSize() ) {
                    CepScreen(viewModel = viewModel)
                }
            }
        }
    }
    @Composable
    fun CepScreen(viewModel: CepViewModel){
        val searchState by viewModel.searchState.collectAsState()

        when (searchState) {
            is SearchState.Initial -> MainLayout(viewModel = viewModel)
            is SearchState.Loading -> LoadingLayout()
            is SearchState.Success -> CEPEncontrado(viewModel)
            is SearchState.Failure -> ErroNaBusca()
        }
    }
}