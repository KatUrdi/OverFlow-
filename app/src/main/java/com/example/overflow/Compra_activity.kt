package com.example.overflow
import android.R
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.overflow.databinding.ActivityCompraBinding
import com.example.overflow.databinding.ActivityIngresoBinding
interface OnItemSelectedListener

class Compra_activity : AppCompatActivity() {
    companion object {
        var MONTOCOMPRA: String = "0"
        var FECHA: String = "12/12/2022"
        var MONTOINGRESOS: String = "0"
        var ID:String = "id"
    }

    private lateinit var binding: ActivityCompraBinding
    private lateinit var bindingPopup: ActivityCompraBinding
    var spinnerSelected = ""
    private lateinit var preference: SharedPreferences
    private lateinit var preference2: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCompraBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.buttonPopup.setOnClickListener {
            validDate(binding.fechaCompra.text.toString())

        }

        binding.buttonHome.setOnClickListener{
            val intent=Intent(this,MainActivity::class.java)
            intent.apply {
                putExtra(MONTOCOMPRA,binding.montoCompra.text.toString())
                putExtra(FECHA,binding.fechaCompra.text.toString())
            }
            startActivity(intent)
        }
        initSpinner()
    }
    fun managePopup() {
        bindingPopup = ActivityCompraBinding.inflate(layoutInflater)
        val dialog = Dialog(this)
        Toast.makeText(this@Compra_activity, "compra añadido exitosamente!", Toast.LENGTH_SHORT)
            .show()
        binding.buttonPopup.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            dialog.dismiss()
        }

    }

    fun managePopup2() {
        bindingPopup = ActivityCompraBinding.inflate(layoutInflater)
        val dialog = Dialog(this)
        Toast.makeText(this@Compra_activity, "Fecha mal ingresada", Toast.LENGTH_SHORT)
            .show()
    }
    fun initSpinner() {
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

    fun validDate(date: String) {
        date.toCharArray()
        if (date.length == 8) {
            if (/*day*/(date[0] == '1' || date[0] == '2' || date[0] == '3' || date[0] == '0') && (date[1] == '1' || date[1] == '2' || date[1] == '3' || date[1] == '4' || date[1] == '5' || date[1] == '6' || date[1] == '7' || date[1] == '8' || date[1] == '9' || date[1] == '0')
                /* - or / */ && (date[2] == '/' || date[2] == '-')
                /*moth*/ && (date[3] == '1' || date[3] == '0') && (date[4] == '1' || date[4] == '2' || date[4] == '3' || date[4] == '4' || date[4] == '5' || date[4] == '6' || date[4] == '7' || date[4] == '8' || date[4] == '9' || date[4] == '0')
                /* - or / */ && (date[5] == '/' || date[5] == '-')) {
                managePopup()
                managePreferences()

            }else
                managePopup2()
        }
    }

    fun managePreferences(){
        val fecha = "@id_fecha"
        val monto = "Monto_id"
        preference = PreferenceManager.getDefaultSharedPreferences(this)
        preference2 = PreferenceManager.getDefaultSharedPreferences(this)
        binding.buttonPopup.setOnClickListener {
            val editor = preference.edit()
            var savedData = binding.fechaCompra.text.toString()
            editor.putString(fecha, savedData)
            editor.apply()

            val editor2 = preference2.edit()
            var savedData2 = binding.montoCompra.text.toString()
            editor.putString(monto, savedData2)
            editor.apply()
        }
    }

}