package br.ufpr.imccalc

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import br.ufpr.imccalc.R.layout.activity_main

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_main)

        val editTextAltura = findViewById<EditText>(R.id.etAltura)
        val editTextPeso = findViewById<EditText>(R.id.etPeso)
        val buttonCalcular = findViewById<Button>(R.id.btnCalcular)
        val buttonLimpar = findViewById<Button>(R.id.btnLimpar)

        buttonCalcular.setOnClickListener {
            val alturaStr = editTextAltura.text.toString().replace(',', '.').trim()
            val pesoStr = editTextPeso.text.toString().replace(',', '.').trim()

            if (alturaStr.isEmpty() || pesoStr.isEmpty()) {
                Toast.makeText(this, "Por favor, preencha todos os campos", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }

            try {
                val alturaFlt = alturaStr.toFloat()
                val pesoFlt = pesoStr.toFloat()

                if (alturaFlt < 0.5f || alturaFlt > 2.5f) {
                    Toast.makeText(this, "Insira uma altura válida (ex: 1.75)", Toast.LENGTH_LONG)
                        .show()
                    return@setOnClickListener
                }

                if (pesoFlt < 2.0f || pesoFlt > 500.0f) {
                    Toast.makeText(this, "Insira um peso válido (ex: 70.5)", Toast.LENGTH_LONG)
                        .show()
                    return@setOnClickListener
                }


                val imc = pesoFlt / (alturaFlt * alturaFlt)
                val imcFormatado = String.format(java.util.Locale.US, "%.2f", imc)


                val categoria = if (imc < 18.5) {
                    "Desnutrição"
                } else if (imc >= 18.5 && imc <= 24.9) {
                    "Normalidade"
                } else if (imc >= 25.0 && imc <= 29.9) {
                    "Sobrepeso"
                } else if (imc >= 30.0 && imc <= 39.9) {
                    "Obesidade"
                } else {
                    "Obesidade mórbida"
                }

                val intent = Intent(this, ResultadoActivity::class.java).apply {
                    putExtra("INTENT_IMC", imcFormatado)
                    putExtra("INTENT_CATEGORIA", categoria)
                }
                startActivity(intent)

            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Por favor, insira apenas números válidos", Toast.LENGTH_LONG)
                    .show()
            }
        }
    }
}