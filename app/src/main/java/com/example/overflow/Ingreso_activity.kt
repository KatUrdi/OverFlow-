package com.example.overflow

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.overflow.databinding.ActivityCompraBinding
import com.example.overflow.databinding.ActivityMainBinding
import com.example.overflow.databinding.ActivityIngresoBinding

class Ingreso_activity : AppCompatActivity() {
    private lateinit var binding: ActivityIngresoBinding

    private lateinit var bindingPopup: ActivityIngresoBinding
    companion object{
        val monto:Int= 15
        val fecha:String="12/12/2022"

    }

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
        Toast.makeText(this@Ingreso_activity, "Ingreso añadido exitosamente!", Toast.LENGTH_SHORT)
            .show()
        binding.buttonPopup.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        bindingPopup.buttonPopup.setOnClickListener {
            dialog.dismiss()
        }

    }



}