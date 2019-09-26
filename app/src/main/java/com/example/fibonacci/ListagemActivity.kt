package com.example.fibonacci

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.listagem_activity.*

class ListagemActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.listagem_activity)

        //Getting other activity values

        var valorinicial: String = intent.getStringExtra("valor")
        var quantidade: String = intent.getStringExtra("valor2")

        //text_view.text = quantidade;

        //Function numeros primos

        if(valorinicial.toInt() != 1){
            //for (i in 0..quantidade.toInt()){
                if (valorinicial.toInt() % valorinicial.toInt() == 0) {
                    text_view.text = "É primo";
                }else {
                    text_view.text = "Não é primo";
                }
            //}
        }else {
            text_view.text = "1 não é primo";
        }


        //Voltando para a Activity anterior

        floatingActionButton.setOnClickListener {
            finish();
        }
    }
}