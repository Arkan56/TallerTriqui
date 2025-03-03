package com.example.taller1_triqui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.taller1_triqui.databinding.CountryItemBinding
import com.squareup.picasso.Picasso

class MyAdapter(private val context: Context, private val arrayList: MutableList<Country>) : BaseAdapter() {

    override fun getCount(): Int {
        return arrayList.size
    }

    override fun getItem(position: Int): Any {
        return arrayList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding = CountryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        var convertView = convertView
        convertView = binding.root

        val country = arrayList[position]

        binding.nameCountry.text = arrayList[position].nameIt

        Picasso.get().load(arrayList[position].bandera).into(binding.imageView)

        convertView.setOnClickListener {
            val intent = Intent(context, CountryDetailActivity::class.java)
            val bundle = Bundle().apply {
                putString("name", country.name)
                putString("capital", country.capital)
                putString("code", country.code)
                putString("nameIt", country.nameIt)
                putString("bandera", country.bandera)
            }
            intent.putExtras(bundle)
            context.startActivity(intent)
        }

        return convertView
    }
}
