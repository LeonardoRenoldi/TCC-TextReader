package model

import org.bson.codecs.pojo.annotations.BsonId

data class User(
    @BsonId
    val email: String,
    val nome: String,
    val senha: String
)
