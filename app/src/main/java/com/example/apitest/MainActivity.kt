package com.example.apitest

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.apitest.CurrencyList.Adapter.RecyclerViewAdapter
import com.example.apitest.Api.RetrofitClient
import com.example.apitest.CurrencyList.Model.CurrencyNameAndSymbol
import com.example.apitest.CurrencyList.Model.ResponseModel
import com.example.apitest.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        callApi()
    }

    private fun callApi() {
        val dataList = arrayListOf<CurrencyNameAndSymbol>()
        RetrofitClient.apiService.getCurrencyList().enqueue(object : Callback<ResponseModel> {
            override fun onResponse(call: Call<ResponseModel>, response: Response<ResponseModel>) {
                if (response.isSuccessful) {
                    if (response.code() == 200 && response.body() != null) {
                        val responseData = response.body()?.data
                        responseData.let {
                            it?.result?.forEach { (currency, symbol) ->
                                dataList.add(CurrencyNameAndSymbol(symbol.name, symbol.symbol))
                            }
                            val adapter = RecyclerViewAdapter(this@MainActivity, dataList)
                            binding.recyclerViewForCurrency.adapter = adapter
                        }
                    } else {
                        Log.d("", "")
                    }
                } else {
                    Log.d("", "")
                }
            }

            override fun onFailure(call: Call<ResponseModel>, t: Throwable) {
                Log.d("", "")
            }
        })
    }

}