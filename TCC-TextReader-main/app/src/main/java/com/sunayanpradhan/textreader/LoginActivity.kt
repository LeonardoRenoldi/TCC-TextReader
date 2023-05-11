package com.sunayanpradhan.textreader

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.leonardo.textreader.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

       val botao_registro = binding.buttonRegister
        val botao_logar = binding.buttonLogin


        botao_registro.setOnClickListener {
            startActivity(Intent(this@LoginActivity,RegistroActivity::class.java))
        }

        botao_logar.setOnClickListener {
            startActivity(Intent(this@LoginActivity,RegistroActivity::class.java))
        }

    }
}


