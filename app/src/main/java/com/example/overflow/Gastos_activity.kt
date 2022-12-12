package com.example.overflow

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.overflow.databinding.ActivityGastosBinding


private lateinit var binding: ActivityGastosBinding

class Gastos_activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGastosBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        // cambiar a la cativity tablas
        binding.buttonTablas.setOnClickListener {
            val intent = Intent(this, Tablas_activity::class.java)
            startActivity(intent)
        }
    }
}