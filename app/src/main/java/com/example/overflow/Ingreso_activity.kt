package com.example.overflow

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.example.overflow.databinding.ActivityCompraBinding
import com.example.overflow.databinding.ActivityMainBinding
import com.example.overflow.databinding.ActivityIngresoBinding

class Ingreso_activity : AppCompatActivity() {
    private lateinit var binding: ActivityIngresoBinding

    private lateinit var bindingPopup: ActivityIngresoBinding

    companion object {
        val monto: Int = 15
        val fecha: String = "12/12/2022"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIngresoBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.buttonPopup.setOnClickListener {
            validDate(binding.fechaIngreso.text.toString())
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
            dialog.dismiss()
        }

    }

    fun managePopup2() {
        bindingPopup = ActivityIngresoBinding.inflate(layoutInflater)
        val dialog = Dialog(this)
        Toast.makeText(this@Ingreso_activity, "Fecha mal ingresada", Toast.LENGTH_SHORT)
            .show()
    }

    fun validDate(date: String) {
        date.toCharArray()
        if (date.length == 8) {
            if (/*day*/(date[0] == '1' || date[0] == '2' || date[0] == '3' || date[0] == '0') && (date[1] == '1' || date[1] == '2' || date[1] == '3' || date[1] == '4' || date[1] == '5' || date[1] == '6' || date[1] == '7' || date[1] == '8' || date[1] == '9' || date[1] == '0') /* - or / */ && (date[2] == '/' || date[2] == '-') /*moth*/ && (date[3] == '1' || date[3] == '0') && (date[4] == '1' || date[4] == '2' || date[4] == '3' || date[4] == '4' || date[4] == '5' || date[4] == '6' || date[4] == '7' || date[4] == '8' || date[4] == '9' || date[4] == '0') /* - or / */ && (date[5] == '/' || date[5] == '-'))
               managePopup()
             else
                managePopup2()
        }
    }
}

