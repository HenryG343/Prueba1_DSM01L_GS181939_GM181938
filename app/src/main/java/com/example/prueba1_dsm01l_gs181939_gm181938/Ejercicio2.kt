package com.example.prueba1_dsm01l_gs181939_gm181938

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.text.DecimalFormat
import kotlin.math.sqrt

class Ejercicio2 : AppCompatActivity() {
    lateinit var lblUsuario:TextView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio2)
        lblUsuario = findViewById(R.id.lblUsuario);
        cargarPreferencias()

        val r1 = findViewById<TextView>(R.id.r1)
        val r2 = findViewById<TextView>(R.id.r2)
        val btn = findViewById<Button>(R.id.button)

        btn.setOnClickListener {
            if (findViewById<EditText>(R.id.editTextNumberSigned).text.isEmpty() || findViewById<EditText>(
                    R.id.editTextNumberSigned2
                ).text.isEmpty() ||
                findViewById<EditText>(R.id.editTextNumberSigned3).text.isEmpty()
            ) {

                r1.setText("Ingresar valores al sistema!")
                r2.setText("Ingresar valores al sistema!")
            } else {
                val number1 =
                    findViewById<EditText>(R.id.editTextNumberSigned).text.toString().toDouble()
                val number2 =
                    findViewById<EditText>(R.id.editTextNumberSigned2).text.toString().toDouble()
                val number3 =
                    findViewById<EditText>(R.id.editTextNumberSigned3).text.toString().toDouble()

                val elevation = (Math.pow(number2, 2.0) - (4 * number1 * number3))
                val raiz = sqrt(elevation)
                val positivo = (-(number2) + raiz) / (2 * number1)
                val negativo = (-(number2) - raiz) / (2 * number1)
                val formato = DecimalFormat("#.##")
                if (positivo.isNaN() || negativo.isNaN()) {
                    r1.setText("No hay solución real")
                    r2.setText("No hay solución real")

                } else {
                    r1.setText(
                        "X1: " + formato.format(positivo)
                    )
                    r2.setText(
                        "X2: " + formato.format(negativo)
                    )
                }
            }
        }
    }
    private fun cargarPreferencias(){
        val preferencias = getSharedPreferences("credenciales", Context.MODE_PRIVATE)
        val user = preferencias.getString("user","No existe la informacion")
        lblUsuario.setText("Bienvenido: " + user)
    }
}