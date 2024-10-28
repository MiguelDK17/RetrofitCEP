package com.migueldev.retrofitcep.model

data class CepResponse(
    val cep: String = "N/A",
    val logradouro: String = "N/A",
    val complemento: String = "N/A",
    val bairro: String = "N/A",
    val localidade: String = "N/A",
    val uf: String = "N/A",
    val ibge: String = "N/A",
    val gia: String = "N/A",
    val ddd: String = "N/A",
    val siafi: String = "N/A",
)