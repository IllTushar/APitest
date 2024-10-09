package com.example.apitest.CurrencyList.Model

data class ResponseModel(
    val success: Boolean,
    val message: String,
    val data: CurrencyData,
)
