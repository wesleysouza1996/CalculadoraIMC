package com.example.meuprimeiroprojeto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import com.example.meuprimeiroprojeto.R.layout.activity_result

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_result)

    supportActionBar?.setHomeButtonEnabled(true) // Habilito o botão
    supportActionBar?.setDisplayHomeAsUpEnabled(true) // Mostro o botão


    val tvResult = findViewById<TextView>(R.id.textview_result)
    val tvClassificacao = findViewById<TextView>(R.id.textview_classificacao)


    val result: Float = intent.getFloatExtra("EXTRA_RESULT", 0.1f)

    tvResult.text = result.toString()

    /* TABELA IMC

        MENOR QUE 18,5      ABAIXO DO PESO
        ENTRE 18,5 E 24,9   NORMAL
        ENTRE 25,0 E 29,9   SOBREPESO 1
        ENTRE 30,0 E 39,9   OBESIDADE 2
        MAIOR QUE 40,0      OBESIDADE GRAVE 3

     */

              // Var é que o valor pode ser reescrito. Val é valor "fixo". Indendente se é de algum Imput / Ou contatenar através da função String.XML
              // += ele contatena com o texto digitando dentro do "" da variável


            val  classificacao = if(result < 18.5f){
                  "ABAIXO DO PESO"

            }else if(result in 18.5f..24.9f){
                  "NORMAL"

            }else if(result >= 25f && result <= 29.9f){
                "SOBREPESO"

            }else if(result >= 30f && result <= 39.9f){
                 "OBESIDADE"

            }else{
                 "OBESIDADE GRAVE"
            }

            tvClassificacao.text = getString(R.string.message_classificacao, classificacao)

        }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)



    }
}