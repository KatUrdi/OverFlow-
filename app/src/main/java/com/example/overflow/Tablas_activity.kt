package com.example.overflow

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.overflow.databinding.ActivityMainBinding
import com.example.overflow.databinding.ActivityTablasBinding


class Tablas_activity : AppCompatActivity() {
    private lateinit var binding: ActivityTablasBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTablasBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        // cambiar a la cativity gastos
        binding.buttonGastos.setOnClickListener {
            val intent = Intent(this, Gastos_activity::class.java)
            startActivity(intent)
        }
    }
}