package model

import java.util.*

data class User(

    val id: String = UUID.randomUUID().toString(),
    val email: String,
    val nome: String,
    val senha: String
)
