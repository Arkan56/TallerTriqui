package com.example.taller1_triqui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.taller1_triqui.databinding.ActivityCountryDetailBinding

class CountryDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCountryDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCountryDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Recibir datos del país seleccionado
        val countryName = intent.getStringExtra("country_name")
        val countryCapital = intent.getStringExtra("country_capital")
        val countryCode = intent.getStringExtra("country_code")

        // Mostrar la información en la UI
        binding.textCountryName.text = "País: $countryName"
        binding.textCountryCapital.text = "Capital: $countryCapital"
        binding.imageFlag.setImageResource(getFlagResource(countryCode ?: ""))
    }

    // Método para obtener la bandera del país basado en el código
    private fun getFlagResource(code: String): Int {
        return when (code) {
            "DE" -> R.drawable.flag_germany
            "AR" -> R.drawable.flag_argentina
            "AU" -> R.drawable.flag_australia
            "AT" -> R.drawable.flag_austria
            "BE" -> R.drawable.flag_belgium
            "BO" -> R.drawable.flag_bolivia
            "BR" -> R.drawable.flag_brazil
            "CL" -> R.drawable.flag_chile
            "CO" -> R.drawable.flag_colombia
            "CU" -> R.drawable.flag_cuba
            "EC" -> R.drawable.flag_ecuador
            "ES" -> R.drawable.flag_spain
            "US" -> R.drawable.flag_usa
            "FR" -> R.drawable.flag_france
            "GB" -> R.drawable.flag_uk
            "GR" -> R.drawable.flag_greece
            "NL" -> R.drawable.flag_netherlands
            "HU" -> R.drawable.flag_hungary
            "IE" -> R.drawable.flag_ireland
            "IS" -> R.drawable.flag_iceland
            "IL" -> R.drawable.flag_israel
            "IT" -> R.drawable.flag_italy
            "JP" -> R.drawable.flag_japan
            "UY" -> R.drawable.flag_uruguay
            "VE" -> R.drawable.flag_venezuela
            else -> R.drawable.flag_default
        }
    }
}
