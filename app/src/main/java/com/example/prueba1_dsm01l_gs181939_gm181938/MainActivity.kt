package com.example.prueba1_dsm01l_gs181939_gm181938

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    lateinit var txtUsuario: EditText
    lateinit var txtContra: EditText
    lateinit var btnEnviar: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txtUsuario = findViewById(R.id.txt1)
        txtContra = findViewById(R.id.txt2)
        btnEnviar = findViewById(R.id.button)
        btnEnviar.setOnClickListener{
            if(txtUsuario.text.isEmpty()||txtContra.text.isEmpty()){
                Toast.makeText(applicationContext, "Ingrese todos los campos", Toast.LENGTH_SHORT).show()
            }else{
                guardarPreferencias()
            }
        }
    }

    private fun guardarPreferencias () {
        val preferences = getSharedPreferences("credenciales",Context.MODE_PRIVATE)
        val usuario = txtUsuario.text.toString()
        val pass = txtContra.text.toString()
        val editor : SharedPreferences.Editor = preferences.edit()
        editor.putString("user",usuario)
        editor.putString("pass",pass)
        editor.commit()
        startActivity(Intent(this,Menu::class.java))
    }


}