package com.migueldev.retrofitcep

import android.content.ContentValues.TAG
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.migueldev.retrofitcep.model.CepResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

//Anotação Hilt de injeção para ViewModel
@HiltViewModel
class CepViewModel @Inject constructor(): ViewModel(){
    private val _cepInfo = MutableStateFlow(CepResponse())
    val cepInfo: StateFlow<CepResponse> = _cepInfo

    private val _seachState = MutableStateFlow<SearchState>(SearchState.Initial)
    val searchState: StateFlow<SearchState> = _seachState.asStateFlow()

    fun searchCep(cep: String){
        viewModelScope.launch {
            _seachState.value = SearchState.Loading
            try {
                val response = RetrofitInstance.api.getCepInfo(cep)
                _cepInfo.value = response
                if (response.erro) _seachState.value = SearchState.Failure else _seachState.value = SearchState.Success(response)
            } catch (e: Exception){
                //Tratar de erros aqui
                Log.d(TAG, "searchCep: Erro ao buscar CEP", e)
                _seachState.value = SearchState.Failure
            }
        }
    }
    fun mudarParaInicio(){
        _seachState.value = SearchState.Initial
    }
}