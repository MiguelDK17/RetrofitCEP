package com.migueldev.retrofitcep

import com.migueldev.retrofitcep.model.CepResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ViaCepApi {
    @GET("{cep}/json/")
    suspend fun getCepInfo(@Path("cep") cep: String): CepResponse
}