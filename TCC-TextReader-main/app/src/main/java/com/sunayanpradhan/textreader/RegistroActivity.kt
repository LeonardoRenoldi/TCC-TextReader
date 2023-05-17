package com.sunayanpradhan.textreader


import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.leonardo.textreader.databinding.ActivityRegistroBinding


class RegistroActivity : AppCompatActivity() {

    lateinit var binding: ActivityRegistroBinding

    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = Firebase.auth

        binding = ActivityRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val botao = binding.buttonRegistrar


        fun createAccount() {
            // [START create_user_with_email]
            val emailRegistro = binding.emailRegister.text.toString()
            val nomeRegistro = binding.nameRegister.text.toString()
            val senhaRegistro = binding.passwordRegister.text.toString()

            if (emailRegistro.isNullOrEmpty() || senhaRegistro.isNullOrEmpty() || nomeRegistro.isNullOrEmpty())  {
                  Toast.makeText(this,"os campos não podem estar vazios", Toast.LENGTH_SHORT).show()
            }else{
                auth.createUserWithEmailAndPassword(emailRegistro, senhaRegistro)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success")
                            val user = auth.currentUser

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.exception)
                            Toast.makeText(
                                baseContext,
                                "Authentication failed.",
                                Toast.LENGTH_SHORT,
                            ).show()

                        }
                    }
                startActivity(Intent(this@RegistroActivity,LoginActivity::class.java))
            }
        }

        botao.setOnClickListener { createAccount()


        }
    }
}












