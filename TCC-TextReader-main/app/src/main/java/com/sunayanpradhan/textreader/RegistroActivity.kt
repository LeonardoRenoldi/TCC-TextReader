package com.sunayanpradhan.textreader

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.leonardo.textreader.databinding.ActivityRegistroBinding
import screen.HomeViewModel


class RegistroActivity : AppCompatActivity() {

    lateinit var binding: ActivityRegistroBinding
    lateinit var homeViewModel:HomeViewModel;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val email = binding.emailRegister.text.toString()
        val nome = binding.nameRegister.text.toString()
        val senha = binding.passwordRegister.text.toString()
        val botao = binding.buttonRegistrar

        botao.setOnClickListener {
         homeViewModel.insertPerson()
        }

    }
}