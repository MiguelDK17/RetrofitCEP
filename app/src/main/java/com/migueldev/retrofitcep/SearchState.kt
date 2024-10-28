package com.migueldev.retrofitcep

import com.migueldev.retrofitcep.model.CepResponse

//classe que retorna ao ViewModel o estado da query(busca)
sealed class SearchState {
    data object Initial: SearchState()
    data object Loading: SearchState()
    data class Success(val result: CepResponse): SearchState()
    data object Failure: SearchState()
}