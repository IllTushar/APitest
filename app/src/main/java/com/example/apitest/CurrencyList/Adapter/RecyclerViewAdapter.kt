package com.example.apitest.CurrencyList.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.apitest.CurrencyList.Model.CurrencyNameAndSymbol
import com.example.apitest.R

class RecyclerViewAdapter(
    private val context: Context,
    private val dataList: ArrayList<CurrencyNameAndSymbol>,
) : RecyclerView.Adapter<RecyclerViewAdapter.myViewHolder>() {

    class myViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val currencyName = itemView.findViewById<TextView>(R.id.currencyName)
        val symbol = itemView.findViewById<TextView>(R.id.symbol)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.single_row_xml, parent, false)
        return myViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        holder.currencyName.text = dataList[position].name
        holder.symbol.text = dataList[position].symbol
    }
}