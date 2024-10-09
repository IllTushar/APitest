package com.example.apitest.CurrencyConverter.Request

data class RequestToConvert(
    val amount: Double,
    val from: String,
    val to: String
)