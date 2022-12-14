package com.example.overflow

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.overflow.databinding.ActivityMainBinding
import com.example.overflow.databinding.ActivityIngresoBinding

class Ingreso_activity : AppCompatActivity() {
    private lateinit var binding: ActivityIngresoBinding

    private lateinit var bindingPopup: ActivityIngresoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIngresoBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.buttonPopup.setOnClickListener {
            managePopup()

        }
    }
    fun managePopup() {
        bindingPopup = ActivityIngresoBinding.inflate(layoutInflater)
        val dialog = Dialog(this)
        dialog.setContentView(bindingPopup.root)
        dialog.setCancelable(true)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        bindingPopup.textTitle.text = "Ingreso añadido exitosamente"

        dialog.show()
        bindingPopup.buttonPopup.setOnClickListener {
            dialog.dismiss()
        }
    }



}

