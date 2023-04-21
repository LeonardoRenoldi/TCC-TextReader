package com.sunayanpradhan.textreader

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sunayanpradhan.textreader.databinding.ActivityLoginBinding





class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

       val botao_registro = binding.buttonRegister


        botao_registro.setOnClickListener {
            startActivity(Intent(this@LoginActivity,RegistroActivity::class.java))
        }

    }
}


