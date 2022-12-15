package com.example.overflow
import android.R
import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.overflow.databinding.ActivityCompraBinding

class Compra_activity : AppCompatActivity() {
    private lateinit var binding: ActivityCompraBinding

    private lateinit var bindingPopup: ActivityCompraBinding
    var spinnerSelected = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCompraBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.buttonPopup.setOnClickListener {
            managePopup()
        }
        initSpinner()
    }

    private fun managePopup() {

        bindingPopup = ActivityCompraBinding.inflate(layoutInflater)
        val dialog = Dialog(this)
        Toast.makeText(this@Compra_activity, "Compra añadida exitosamente!", Toast.LENGTH_SHORT)
            .show()
        binding.buttonPopup.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        bindingPopup.buttonPopup.setOnClickListener {
            dialog.dismiss()
        }

    }

    private fun initSpinner() {
        val dataList = mutableListOf<String>()
        dataList.add("Comida")
        dataList.add("Ropa")
        dataList.add("Alquiler")
        dataList.add("Otros")

        val adapter = ArrayAdapter(
            this,
            R.layout.simple_spinner_item,
            dataList
        )

        binding.tipoCompra.adapter = adapter
        binding.tipoCompra.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
                binding.textViewSelectedSpinner.text = dataList[position]
                spinnerSelected = dataList[position]
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }

        }
    }
}