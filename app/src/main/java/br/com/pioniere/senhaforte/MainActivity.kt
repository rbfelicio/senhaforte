package br.com.pioniere.senhaforte

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etChars = findViewById<EditText>(R.id.etChars)
        val btnGeneratePass = findViewById<Button>(R.id.btnGeneratePass)
        val tvShowPass = findViewById<TextView>(R.id.tvShowPass)
        val btnCopy = findViewById<Button>(R.id.btnCopy)
        val btnSave = findViewById<Button>(R.id.btnSave)

        btnGeneratePass.setOnClickListener {
            var nChars: Int = etChars.text.toString().toInt()
            generatePass(nChars, false)
        }
    }

    /**
     * Function for generate a strong password
     */
    fun generatePass(numberOfChars: Int, specialChars: Boolean) {
//    val STRING_CHARACTERS = ('0'..'z').toList().toTypedArray()

        if (numberOfChars > 32) {
            Toast.makeText(this, "Quantidade de caracteres muito grande", Toast.LENGTH_LONG).show()
        } else {
            var stringChars: Array<Char>
            if (specialChars) {
                stringChars =
                    ("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%&-").toList()
                        .toTypedArray()
            } else {
                stringChars =
                    ("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ").toList()
                        .toTypedArray()
            }
            val password = (1..numberOfChars).map { stringChars.random() }.joinToString("")
            tvShowPass.text = password
        }
    }
}
