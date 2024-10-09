package com.example.apitest.Api

import com.example.apitest.CurrencyConverter.Request.RequestToConvert
import com.example.apitest.CurrencyConverter.Response.ConvertCurrencyResposne
import com.example.apitest.CurrencyList.Model.ResponseModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiInterface {
    @Headers(
        "x-api-key: aMFouLkMjcxGopFBPmzjWGMKQCkVKPDMsghukTvPHaPWzsqALZZFfGRtpBgvEKVVLGDJjDBavveHcoVKhuqjovsRWhkgGEQiyRmX",
        "x-app-version: 1.0.0",
        "x-apihub-key: bV0ZGg3MvUzLKfRdJKpJ208oIZD4LsIMr0c7RrqnHM9XWhx4rI",
        "x-apihub-host: Currency-Converter.allthingsdev.co",
        "x-apihub-endpoint: f7a950b7-e795-4241-b4ab-1c646fcabadc"
    )
    @GET("api/v1/currency/list")
    fun getCurrencyList(): Call<ResponseModel>

    @Headers(
        "x-api-key: aMFouLkMjcxGopFBPmzjWGMKQCkVKPDMsghukTvPHaPWzsqALZZFfGRtpBgvEKVVLGDJjDBavveHcoVKhuqjovsRWhkgGEQiyRmX",
        "x-app-version: 1.0.0",
        "x-apihub-key: bV0ZGg3MvUzLKfRdJKpJ208oIZD4LsIMr0c7RrqnHM9XWhx4rI",
        "x-apihub-host: Currency-Converter.allthingsdev.co",
        "x-apihub-endpoint: a0a275dc-a8ba-4d34-bb29-2787556829d2"
    )
    @POST("api/v1/currency/conversion")
    fun convertCurrency(@Body requestToConvert: RequestToConvert): Call<ConvertCurrencyResposne>

}