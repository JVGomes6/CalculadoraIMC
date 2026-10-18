package br.ufpr.imccalc

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity

class ResultadoActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        val tvImcCalculado = findViewById<TextView>(R.id.tvImcCalculado)
        val tvCategoriaResultado = findViewById<TextView>(R.id.tvCategoriaResultado)
        val buttonVoltar = findViewById<Button>(R.id.btnVoltar)


        val imc = intent.getStringExtra("INTENT_IMC")
        val categoria = intent.getStringExtra("INTENT_CATEGORIA")

        tvImcCalculado.text = "IMC: $imc"
        tvCategoriaResultado.text = "Classificação: $categoria"


        buttonVoltar.setOnClickListener {
            finish()
        }
    }
}