package com.sunayanpradhan.textreader

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sunayanpradhan.textreader.databinding.ActivityRegistroBinding
import databaseUtils.DataBaseConnection
import model.User
import model.UserResponse


class RegistroActivity : AppCompatActivity() {

    lateinit var binding: ActivityRegistroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val email = binding.emailRegister.text.toString()
        val nome = binding.nameRegister.text.toString()
        val senha = binding.passwordRegister.text.toString()
        val botao = binding.buttonRegistrar
        val user_resp = UserResponse(email, senha, nome)
        val cadastro = User(email,email, nome, senha)

        botao.setOnClickListener {
            val cliente = DataBaseConnection.getClient()
            val database = cliente.getDatabase("seu-nome-de-banco-de-dados")
            val collection = database.getCollection("sua-coleção-de-login", UserResponse::class.java)

            collection.insertOne(user_resp)

            cliente.close()
        }
    }
}