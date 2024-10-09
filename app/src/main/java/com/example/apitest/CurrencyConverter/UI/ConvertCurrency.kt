package com.example.apitest.CurrencyConverter.UI

import android.app.ProgressDialog
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.apitest.Api.RetrofitClient
import com.example.apitest.CurrencyConverter.Request.RequestToConvert
import com.example.apitest.CurrencyConverter.Response.ConvertCurrencyResposne
import com.example.apitest.databinding.ActivityConvertCurrencyBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.Locale

class ConvertCurrency : AppCompatActivity() {
    lateinit var binding: ActivityConvertCurrencyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConvertCurrencyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.convert.setOnClickListener {
            val from = binding.from.text.toString().toUpperCase(Locale.ROOT).trim()
            val to = binding.to.text.toString().toUpperCase(Locale.ROOT).trim()
            val amount = binding.amount.text.toString().trim()
            if (!from.isEmpty() && !to.isEmpty() && !amount.isEmpty()) {
                callApi(from, to, amount)
            }
        }
    }

    private fun callApi(from: String, to: String, amount: String) {
        val pd = ProgressDialog(this@ConvertCurrency)
        pd.show()
        pd.setMessage("Please wait!!")
        val newAmount = 82.81744217935824
        val requestClass = RequestToConvert(newAmount, from, to)
        RetrofitClient.apiService.convertCurrency(requestClass)
            .enqueue(object : Callback<ConvertCurrencyResposne> {
                override fun onResponse(
                    call: Call<ConvertCurrencyResposne>,
                    response: Response<ConvertCurrencyResposne>,
                ) {
                    if (response.isSuccessful) {
                        if (response.code() == 200 && response.body() != null) {
                            Toast.makeText(
                                this@ConvertCurrency,
                                response.body()?.data?.result.toString(),
                                Toast.LENGTH_LONG
                            ).show()
                            pd.dismiss()
                        } else {
                            Log.d("ConvertCurrency", "response code is not 200")
                        }
                    } else {
                        Log.d(
                            "ConvertCurrency",
                            "ResponseCode: ${response.code()},Response Message: ${response.body()?.message}"
                        )
                    }
                }

                override fun onFailure(call: Call<ConvertCurrencyResposne>, t: Throwable) {
                    Log.d("ConvertCurrency", t.toString())
                }
            })
    }
}