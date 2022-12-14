package com.example.overflow

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.overflow.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // cambiar a la cativity tablas
        binding.buttonTablas.setOnClickListener {
            val intent = Intent(this, Tablas_activity::class.java)
            startActivity(intent)
        }

        // cambiar a la cativity gastos
        binding.buttonGastos.setOnClickListener {
            val intent = Intent(this, Gastos_activity::class.java)
            startActivity(intent)
        }



    }

}