package com.example.overflow.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.ViewParent
import androidx.recyclerview.widget.RecyclerView
import java.lang.reflect.Type
import java.text.FieldPosition

class GastosAdapter: RecyclerView.Adapter<GastosAdapter.GastosViewHolder>() {
    private val gastos = mutableListOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):GastosViewHolder =
        GastosViewHolder(
            ItemGastosBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    override fun onBindViewHolder(holder: GastosViewHolder, position: Int) {
        holder.binding(gastos[position])
    }

    override fun getItemCount(): Int = gastos.size

    inner class GastosViewHolder(private val binding: ItemGastosBinding):
            RecyclerView.ViewHolder(binding.root){
                fun binding(data: String){
                    // binding.textViewGastos.text = data
                }
            }
    fun  addGastos(list: List<String>){
        gastos.clear()
        gastos.addAll(list)
    }
}