package com.example.taller1_triqui

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.taller1_triqui.databinding.ActivityTriquiBinding

class TriquiActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTriquiBinding
    private var turnoJugador = true // true = X, false = O
    private var tablero = Array(3) { arrayOfNulls<Button>(3) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTriquiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Asociamos los botones del GridLayout con el array tablero
        tablero[0][0] = binding.button00
        tablero[0][1] = binding.button01
        tablero[0][2] = binding.button02
        tablero[1][0] = binding.button10
        tablero[1][1] = binding.button11
        tablero[1][2] = binding.button12
        tablero[2][0] = binding.button20
        tablero[2][1] = binding.button21
        tablero[2][2] = binding.button22

        // Configurar los botones para que reaccionen al clic
        for (fila in 0..2) {
            for (columna in 0..2) {
                tablero[fila][columna]?.setOnClickListener {
                    marcarCasilla(tablero[fila][columna]!!)
                }
            }
        }

        // Botón de reinicio del juego
        binding.btnRestart.setOnClickListener {
            reiniciarJuego()
        }
    }

    private fun marcarCasilla(boton: Button) {
        if (boton.text.isNotEmpty()) return // No se puede sobreescribir una casilla ocupada

        if (turnoJugador) {
            boton.text = "X"
            boton.setBackgroundColor(resources.getColor(android.R.color.holo_green_light))
        } else {
            boton.text = "O"
            boton.setBackgroundColor(resources.getColor(android.R.color.holo_blue_dark))
        }

        // Verificar si alguien ganó
        if (verificarGanador()) {
            Toast.makeText(this, "¡${if (turnoJugador) "Jugador X" else "Jugador O"} ha ganado!", Toast.LENGTH_LONG).show()
            deshabilitarTablero()
        }

        // Cambiar turno
        turnoJugador = !turnoJugador
    }

    private fun verificarGanador(): Boolean {
        val simbolo = if (turnoJugador) "X" else "O"

        // Revisar filas y columnas
        for (i in 0..2) {
            if (tablero[i][0]?.text == simbolo && tablero[i][1]?.text == simbolo && tablero[i][2]?.text == simbolo) return true
            if (tablero[0][i]?.text == simbolo && tablero[1][i]?.text == simbolo && tablero[2][i]?.text == simbolo) return true
        }

        // Revisar diagonales
        if (tablero[0][0]?.text == simbolo && tablero[1][1]?.text == simbolo && tablero[2][2]?.text == simbolo) return true
        if (tablero[0][2]?.text == simbolo && tablero[1][1]?.text == simbolo && tablero[2][0]?.text == simbolo) return true

        return false
    }

    private fun deshabilitarTablero() {
        for (fila in 0..2) {
            for (columna in 0..2) {
                tablero[fila][columna]?.isEnabled = false
            }
        }
    }

    private fun reiniciarJuego() {
        turnoJugador = true
        for (fila in 0..2) {
            for (columna in 0..2) {
                tablero[fila][columna]?.text = ""
                tablero[fila][columna]?.isEnabled = true
                tablero[fila][columna]?.setBackgroundColor(resources.getColor(android.R.color.darker_gray))
            }
        }
    }
}
