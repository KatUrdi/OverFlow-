package com.example.overflow
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.overflow.databinding.ActivityCompraBinding


class Compra_activity : AppCompatActivity() {
    private lateinit var binding: ActivityCompraBinding

    private lateinit var bindingPopup: ActivityCompraBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCompraBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.buttonPopup.setOnClickListener {
            managePopup()

        }
    }
    fun managePopup() {
        bindingPopup = ActivityCompraBinding.inflate(layoutInflater)
        val dialog = Dialog(this)
        dialog.setContentView(bindingPopup.root)
        dialog.setCancelable(true)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        bindingPopup.textTitle.text = "Compra añadido exitosamente"

        dialog.show()
        bindingPopup.buttonPopup.setOnClickListener {
            dialog.dismiss()
        }
    }
}
