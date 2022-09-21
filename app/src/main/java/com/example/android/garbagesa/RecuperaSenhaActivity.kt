package com.example.android.garbagesa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class RecuperaSenhaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recupera_senha)
    }

    fun acessarLogin (view: View) {

        val txv_email: EditText = findViewById(R.id.txv_email)
        val blank = txv_email.text.toString().equals("") || txv_email.length() == 0

        if (!blank) {

            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)

            Toast.makeText(this, "Email para recuperação de senha enviado." ,
                Toast.LENGTH_SHORT).show()

        } else {

            Toast.makeText(this, "Digitar um email válido" ,
                Toast.LENGTH_SHORT).show()

        }
    }
}