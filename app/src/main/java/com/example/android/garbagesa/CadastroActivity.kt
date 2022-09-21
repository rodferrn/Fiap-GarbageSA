package com.example.android.garbagesa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.android.garbagesa.R.*

class CadastroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_cadastro)
    }

    fun acessarLogin(view: View) {

        val txv_name: EditText = findViewById(R.id.txv_name)
        val txv_email: EditText = findViewById(R.id.txv_email)
        val txv_telefone: EditText = findViewById(R.id.txv_telefone)
        val txv_cpf: EditText = findViewById(R.id.txv_cpf)
        val txv_senha: EditText = findViewById(R.id.txv_senha)
        val txv_confirmaSenha: EditText = findViewById(R.id.txv_confirmaSenha)
        val cb_termos: CheckBox = findViewById(R.id.terms)

        val samePassword = txv_senha.text.toString().equals(txv_confirmaSenha.text.toString())

        val blank = txv_name.text.toString().equals("") || txv_name.length() == 0
                || txv_email.text.toString().equals("") || txv_email.length() == 0
                || txv_telefone.text.toString().equals("") || txv_telefone.length() == 0
                || txv_cpf.text.toString().equals("") || txv_cpf.length() == 0
                || txv_senha.text.toString().equals("") || txv_senha.length() == 0
                || txv_confirmaSenha.text.toString().equals("") || txv_confirmaSenha.length() == 0

        if (cb_termos.isChecked && samePassword && !blank) {

            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)

            Toast.makeText(this, "Cadastro efetuado com sucesso. Retornando a tela de login." ,
                Toast.LENGTH_SHORT).show()

        } else if (!cb_termos.isChecked) {

            Toast.makeText(this, "Favor aceitar os termos de condições antes de clicar em Cadastrar." ,
                Toast.LENGTH_SHORT).show()

        } else if (!samePassword) {

            Toast.makeText(this, "Favor utilizar a mesma senha para cadastro." ,
                Toast.LENGTH_SHORT).show()

        } else {

            Toast.makeText(this, "Favor preencher todos os campos" ,
                Toast.LENGTH_SHORT).show()

        }

    }
}