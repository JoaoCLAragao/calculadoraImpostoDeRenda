package br.com.cotemig.calculadoraimpostoderenda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var kt_salario = findViewById<EditText>(R.id.et_salario)
        var btnCalcula = findViewById<Button>(R.id.btn_calculaSofrimento)
        var kt_resultado = findViewById<TextView>(R.id.textViewResultado)


        btnCalcula.setOnClickListener {
            calculaImpostoDeRenda(kt_salario.text.toString().toDouble())
        }


    }

    fun calculaImpostoDeRenda(salario: Double) {

        var imposto = 0.0
        var liquido = salario

        if (salario > 4664.68) {
            imposto = salario * 0.275
            liquido = (salario - imposto) + 869.36
        } else if (salario >= 3751.06) {
            imposto = salario * 0.225
            liquido = (salario - imposto) + 636.13
        } else if (salario >= 2826.66) {
            imposto = salario * 0.15
            liquido = (salario - imposto) + 354.8
        } else if (salario >= 1903.99) {
            imposto = salario * 0.075
            liquido = (salario - imposto) + 142.8
        }

        var resultadoSalario = findViewById<TextView>(R.id.textViewResultado)
        var resultadoImposto = findViewById<TextView>(R.id.textViewImposto)

        resultadoSalario.text = "Salario Liquido: " + liquido
        resultadoImposto.text = "Imposto: " + imposto
    }
}