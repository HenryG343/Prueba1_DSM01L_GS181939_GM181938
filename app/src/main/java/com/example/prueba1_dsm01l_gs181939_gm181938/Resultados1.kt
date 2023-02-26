package com.example.prueba1_dsm01l_gs181939_gm181938

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Resultados1 : AppCompatActivity() {
    //lbl
    lateinit var lblCode: TextView
    lateinit var lblName: TextView
    lateinit var lblVentas: TextView
    lateinit var lblMes: TextView
    lateinit var lblPorcentaje: TextView
    lateinit var lblTotal: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultados1)
        lblCode = findViewById(R.id.lblCode)
        lblName = findViewById(R.id.lblName)
        lblVentas = findViewById(R.id.lblVentas)
        lblMes = findViewById(R.id.lblMes)
        lblPorcentaje = findViewById(R.id.lblPorcentaje)
        lblTotal = findViewById(R.id.textView13)
        cargarPreferencias()
    }
    private fun cargarPreferencias(){
        val preferencias = getSharedPreferences("ej1", Context.MODE_PRIVATE)
        val codigo = preferencias.getString("code","No existe la informacion")
        val nombre = preferencias.getString("name","No existe la informacion")
        val mes = preferencias.getString("mes","No existe la informacion")
        val porcentaje = preferencias.getString("porcentaje","No existe la informacion")
        val ventas = preferencias.getString("ventas","No existe la informacion")
        val total = preferencias.getString("total","No existe la informacion")
        lblCode.setText(codigo)
        lblName.setText(nombre)
        lblVentas.setText(ventas)
        lblMes.setText(mes)
        lblPorcentaje.setText(porcentaje)
        lblTotal.setText(total)

    }
}