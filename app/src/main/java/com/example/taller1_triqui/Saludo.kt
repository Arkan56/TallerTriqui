package com.example.taller1_triqui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.taller1_triqui.databinding.ActivitySaludoBinding
import com.example.taller1_triqui.databinding.ActivityTriquiBinding

class Saludo : AppCompatActivity() {
    lateinit var binding: ActivitySaludoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySaludoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val paquete = intent.getBundleExtra("paquete")
        val idioma = paquete!!.getString("Lenguaje")

        // Personaliza el saludo según el idioma seleccionado
        val saludo = when (idioma) {
            "Español"  -> "¡Buenos días!"
            "English"  -> "Good morning!"
            "Français" -> "Bonjour!"
            "Deutsch"  -> "Guten Morgen!"
            "Italiano" -> "Buongiorno!"
            else       -> "Hello!"
        }

        binding.textSaludo.text = saludo
        }
    }
