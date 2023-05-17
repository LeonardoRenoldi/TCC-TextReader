package com.sunayanpradhan.textreader

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.leonardo.textreader.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


       val botao_registro = binding.buttonRegister
        val botao_logar = binding.buttonLogin
        val logEmail = binding.userInput.text.toString()
       val logSenha = binding.passwordInput.text.toString()


        botao_registro.setOnClickListener {
            startActivity(Intent(this@LoginActivity,RegistroActivity::class.java))
        }

        botao_logar.setOnClickListener {
            if (logEmail.isEmpty()){
                Toast.makeText(this,"Todos os campos devem ser preenchidos!",Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this,"Login com sucesso!",Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this@LoginActivity,MainActivity::class.java))
                    }

            }
        }


}





