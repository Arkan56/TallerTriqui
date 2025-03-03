package com.example.taller1_triqui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.taller1_triqui.databinding.ActivityCountryDetailBinding
import com.squareup.picasso.Picasso

class CountryDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCountryDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCountryDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras
        if (bundle != null) {
            val name = bundle.getString("name")
            val capital = bundle.getString("capital")
            val code = bundle.getString("code")
            val nameIt = bundle.getString("nameIt")
            val bandera = bundle.getString("bandera")

            binding.textViewCountryName.text = name
            binding.textViewCapital.text = "Capital: $capital"
            binding.textViewCode.text = "Código: $code"
            binding.textViewNameIt.text = "Nombre Internacional: $nameIt"
            Picasso.get().load(bandera).into(binding.imageViewFlag)
        }
    }
}
