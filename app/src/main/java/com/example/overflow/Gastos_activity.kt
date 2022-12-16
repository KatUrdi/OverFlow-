package com.example.overflow

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.overflow.adapter.PresentationCardAdapter
import com.example.overflow.databinding.ActivityGastosBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Gastos_activity : AppCompatActivity() {
    companion object {
        var MONTO: String = "0"
        var FECHA: String = "12/12/2022"
        var ID: String = "id"
    }
    private lateinit var binding: ActivityGastosBinding
    lateinit var addFAB: FloatingActionButton
    lateinit var ingresoFAB: FloatingActionButton
    lateinit var compraFAB: FloatingActionButton
    var fabVisible = false
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
        // recycler view
        setRecyclerView()
        // flotting button
        // initializing variables of floating
        // action button on below line.
        addFAB = findViewById(R.id.Add_fab)
        ingresoFAB = findViewById(R.id.ingreso_fab) //home
        compraFAB = findViewById(R.id.compra_fab)

        // on below line we are initializing our
        // fab visibility boolean variable
        fabVisible = false

        // on below line we are adding on click listener
        // for our add floating action button
        addFAB.setOnClickListener {
            // on below line we are checking
            // fab visible variable.
            if (!fabVisible) {

                // if its false we are displaying home fab
                // and settings fab by changing their
                // visibility to visible.
                ingresoFAB.show()
                compraFAB.show()

                // on below line we are setting
                // their visibility to visible.
                ingresoFAB.visibility = View.VISIBLE
                compraFAB.visibility = View.VISIBLE

                // on below line we are checking image icon of add fab
                addFAB.setImageDrawable(resources.getDrawable(R.drawable.icono_plus))

                // on below line we are changing
                // fab visible to true
                fabVisible = true
            } else {

                // if the condition is true then we
                // are hiding home and settings fab
                ingresoFAB.hide()
                compraFAB.hide()

                // on below line we are changing the
                // visibility of home and settings fab
                ingresoFAB.visibility = View.GONE
                compraFAB.visibility = View.GONE

                // on below line we are changing image source for add fab
                addFAB.setImageDrawable(resources.getDrawable(R.drawable.icono_plus))

                // on below line we are changing
                // fab visible to false.
                fabVisible = false
            }
        }

        // on below line we are adding
        // click listener for our home fab
        binding.ingresoFab.setOnClickListener {
            // on below line we are displaying a toast message.
            val intent = Intent(this, Ingreso_activity::class.java)
            startActivity(intent)
        }

        // on below line we are adding on
        // click listener for settings fab
        binding.compraFab.setOnClickListener {
            // on below line we are displaying a toast message.
            val intent = Intent(this, Compra_activity::class.java)
            startActivity(intent)
        }
        // recycler View

    }

    fun setRecyclerView() {
        val mutableList = mutableListOf<String>()
        mutableList.add("70")
        mutableList.add("8")

        presentationCardAdapter.addPresentationCards(mutableList)

        binding.recyclerViewItemGastos.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = presentationCardAdapter
        }
    }

}