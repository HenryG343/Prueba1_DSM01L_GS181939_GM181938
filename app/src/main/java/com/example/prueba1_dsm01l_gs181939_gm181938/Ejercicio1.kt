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

class Ejercicio1 : AppCompatActivity() {
    lateinit var lblUsuario:TextView
    @SuppressLint("MissingInflatedId")
    //EditText
    lateinit var txtCodigo: EditText
    lateinit var txtNombre: EditText
    lateinit var txtTotal: EditText
    lateinit var txtMes: EditText
    //btn
    lateinit var btnEnviar: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio1)
        lblUsuario = findViewById(R.id.lblUsuario)
        txtCodigo = findViewById(R.id.txt1)
        txtNombre = findViewById(R.id.txt2)
        txtTotal = findViewById(R.id.txt3)
        txtMes = findViewById(R.id.txt4)
        btnEnviar = findViewById(R.id.button)
        cargarPreferencias()
        btnEnviar.setOnClickListener{
            if(txtCodigo.text.isEmpty() || txtNombre.text.isEmpty() || txtTotal.text.isEmpty() || txtMes.text.isEmpty()){
                Toast.makeText(applicationContext, "Ingrese todos los campos solicitados", Toast.LENGTH_SHORT).show()
            }else if(txtMes.text.toString().toInt()<1||txtMes.text.toString().toInt()>12){
                    Toast.makeText(applicationContext, "El mes no es valido", Toast.LENGTH_SHORT).show()
            }else{
                val total = txtTotal.text.toString().toDouble()
                val porcentaje:Double
                val comTotal:Double
                if ( total < 500){
                    porcentaje = 0.0
                }else if(total > 500 && total < 1000){
                    porcentaje = 5.0
                }else if(total > 1000 && total < 2000){
                    porcentaje = 10.0
                }
                else if(total > 2000 && total < 3000){
                    porcentaje = 15.0
                }
                else if(total > 3000 && total < 4000){
                    porcentaje = 20.0
                }else{
                    porcentaje = 30.0
                }
                comTotal = total*(porcentaje/100)
                val preferences = getSharedPreferences("ej1",Context.MODE_PRIVATE)
                val editor : SharedPreferences.Editor = preferences.edit()
                editor.putString("code",txtCodigo.text.toString())
                editor.putString("name",txtNombre.text.toString())
                editor.putString("mes",txtMes.text.toString())
                editor.putString("porcentaje",porcentaje.toString())
                editor.putString("ventas",txtTotal.text.toString())
                editor.putString("total",comTotal.toString())
                editor.commit()
                startActivity(Intent(this,Resultados1::class.java))
            }
        }
    }
    private fun cargarPreferencias(){
        val preferencias = getSharedPreferences("credenciales", Context.MODE_PRIVATE)
        val user = preferencias.getString("user","No existe la informacion")
        lblUsuario.setText("Bienvenido: " + user)
    }
}