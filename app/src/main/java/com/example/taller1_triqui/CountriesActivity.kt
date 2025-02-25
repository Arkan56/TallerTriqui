package com.example.taller1_triqui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.taller1_triqui.databinding.ActivityCountriesBinding
import org.json.JSONObject
import java.io.InputStream

class CountriesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCountriesBinding
    private val countryList = mutableListOf<Country>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCountriesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Cargar los países desde el JSON
        loadCountriesFromJson()

        // Configurar RecyclerView
        binding.recyclerCountries.layoutManager = LinearLayoutManager(this)
        val adapter = CountryAdapter(countryList) { country ->
            openCountryDetail(country)
        }
        binding.recyclerCountries.adapter = adapter
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
                code = countryJson.getString("sigla")
            )
            countryList.add(country)
        }
    }

    private fun openCountryDetail(country: Country) {
        val intent = Intent(this, CountryDetailActivity::class.java).apply {
            putExtra("country_name", country.name)
            putExtra("country_capital", country.capital)
            putExtra("country_code", country.code)
        }
        startActivity(intent)
    }
}
