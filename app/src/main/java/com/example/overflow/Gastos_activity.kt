package com.example.overflow

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.overflow.adapter.PresentationCardAdapter
import com.example.overflow.databinding.ActivityGastosBinding

class Gastos_activity : AppCompatActivity() {

    private lateinit var binding: ActivityGastosBinding
    private val presentationCardAdapter by lazy { PresentationCardAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGastosBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        // switch to the activity "tablas"
        binding.buttonTablas.setOnClickListener {
            val intent = Intent(this, Tablas_activity::class.java)
            startActivity(intent)
        }
        setRecyclerView()
    }

    // recycler View
    fun setRecyclerView(){
        val mutableList = mutableListOf<String>()
        mutableList.add("70")
        mutableList.add("8")

        presentationCardAdapter.addPresentationCards(mutableList)

        binding.recyclerViewItemGastos.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter= presentationCardAdapter
        }
    }
}