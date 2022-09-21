package com.example.android.garbagesa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    fun acessarCadastro(view: View) {
        val cadastro = Intent(this, CadastroActivity::class.java)
        startActivity(cadastro)

    }

    fun acessarRecuperaSenha(view: View) {
        val recupera = Intent(this, RecuperaSenhaActivity::class.java)
        startActivity(recupera)
    }

    fun acessarTelaPrincipal(view: View) {

        val login_emailid: EditText = findViewById(R.id.login_emailid)
        val login_password: EditText = findViewById(R.id.login_password)

        val blank = login_emailid.text.toString().equals("") || login_emailid.length() == 0
                || login_password.text.toString().equals("") || login_password.length() == 0

        if (!blank) {
            val principal = Intent(this, TelaPrincipalActivity::class.java)
            startActivity(principal)
        } else

            Toast.makeText(this, "Preencher email e senha." ,
                Toast.LENGTH_SHORT).show()

    }

}