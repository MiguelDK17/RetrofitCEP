package com.migueldev.retrofitcep

import android.content.ContentValues.TAG
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.migueldev.retrofitcep.model.CepResponse
import kotlinx.coroutines.launch

class CepViewModel: ViewModel(){
    private val _cepInfo = MutableLiveData<CepResponse>()
    val cepInfo: LiveData<CepResponse> = _cepInfo

    fun searchCep(cep: String){
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getCepInfo(cep)
                _cepInfo.postValue(response)
            } catch (e: Exception){
                //Tratar de erros aqui
                Log.d(TAG, "searchCep: Erro ao buscar CEP", e)
            }
        }
    }
}