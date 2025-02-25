package com.example.taller1_triqui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.get
import com.example.taller1_triqui.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root) //La asociacion de Front con Back

        binding.btnTicTacToe.setOnClickListener{
            val i =Intent(this, TriquiActivity::class.java)
            startActivity(i)
        }

        binding.btnRandomGreet.setOnClickListener{
            val i=Intent(this, Saludo::class.java)
            val caja = Bundle()
            caja.putString("Lenguaje",binding.spinnerLanguages.selectedItem.toString())
            i.putExtra("paquete", caja)
            startActivity(i)
        }

        binding.btnCountries.setOnClickListener {
            val intent = Intent(this, CountriesActivity::class.java)
            startActivity(intent)
        }
    }
}