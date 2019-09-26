package com.example.fibonacci

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)


        //Settando uma variavel para cada componente

        val seek = findViewById<SeekBar>(R.id.seek_bar);
        //val textview = findViewById<TextView>(R.id.text_view);
        val edittext = findViewById<EditText>(R.id.editText);
        val edittext2 = findViewById<EditText>(R.id.editText2);

        //Verificando se tem digitação no input do scroll

        //edittext2.addTextChangedListener(object : TextWatcher {

         //   override fun afterTextChanged(s: Editable) {}

          //  override fun beforeTextChanged(s: CharSequence, start: Int,
          //                                 count: Int, after: Int) {
          //  }

          //  override fun onTextChanged(s: CharSequence, start: Int,
           //                            before: Int, count: Int) {
           //     seek.setProgress(0);
           // }
       // })

        //Mandando para outra tela com as props

        fab.setOnClickListener { view ->
            //Snackbar.make(view, "Evento de clique", Snackbar.LENGTH_LONG)
            //        .setAction("Action", null).show()

            //Intent mandar para outra tela

            val intent = Intent(this, ListagemActivity::class.java)
            // To pass any data to next activity
            intent.putExtra("valor", edittext.text.toString())
            intent.putExtra("valor2", edittext2.text.toString())
            // start your next activity
            startActivity(intent)
        }

        //Scrollbar

        // Set a SeekBar change listener
        seek.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                // Display the current progress of SeekBar
                //textview.text = "Progress : $i"
                //edittext.setText("Progress : $i", TextView.BufferType.EDITABLE);
                edittext2.setText("$i", TextView.BufferType.EDITABLE);
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                // Do something
                Toast.makeText(applicationContext,"Comecei o Tracking",Toast.LENGTH_SHORT).show()
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                // Do something
                Toast.makeText(applicationContext,"Terminei o Tracking",Toast.LENGTH_SHORT).show()
                //seek.setProgress(0);
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when(item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
