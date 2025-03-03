package com.example.taller1_triqui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.taller1_triqui.databinding.ActivityCountriesBinding
import org.json.JSONObject

class CountriesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCountriesBinding
    private val countryList = mutableListOf<Country>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCountriesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadCountriesFromJson()
        var adapter = MyAdapter(this, countryList)
        binding.countryList.adapter = adapter

    }

    private fun loadCountriesFromJson() {
        val json: String = assets.open("paises.json").bufferedReader().use { it.readText() }
        val jsonObject = JSONObject(json)
        val jsonArray = jsonObject.getJSONArray("paises")

        for (i in 0 until jsonArray.length()) {
            val countryJson = jsonArray.getJSONObject(i)
            val country = Country(
                name = countryJson.getString("nombre_pais"),
                capital = countryJson.getString("capital"),
                code = countryJson.getString("sigla"),
                nameIt = countryJson.getString("nombre_pais_int"),
                bandera = countryJson.getString("bandera")
            )
            countryList.add(country)
        }
    }
}
