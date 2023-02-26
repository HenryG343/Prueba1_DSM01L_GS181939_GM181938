package com.example.prueba1_dsm01l_gs181939_gm181938

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class Menu : AppCompatActivity() {
    lateinit var lblUsuario: TextView
    lateinit var btnEj1: Button
    lateinit var btnEj2: Button
    lateinit var btnCS: Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        lblUsuario = findViewById(R.id.lblUsuario);
        cargarPreferencias()
        btnEj1 = findViewById(R.id.btnEj1)
        btnEj1.setOnClickListener{
            startActivity(Intent(this,Ejercicio1::class.java))
        }
        btnEj2 = findViewById(R.id.btnEj2)
        btnEj2.setOnClickListener{
            startActivity(Intent(this,Ejercicio2::class.java))
        }
        btnCS = findViewById(R.id.btnCS)
        btnCS.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
    private fun cargarPreferencias(){
        val preferencias = getSharedPreferences("credenciales", Context.MODE_PRIVATE)
        val user = preferencias.getString("user","No existe la informacion")
        lblUsuario.setText("Bienvenido: " + user + "\nElija una opción")
    }
}