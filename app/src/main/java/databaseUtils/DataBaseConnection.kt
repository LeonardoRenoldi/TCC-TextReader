package databaseUtils

import com.mongodb.MongoClientSettings
import com.mongodb.MongoCredential
import com.mongodb.ServerAddress
import com.mongodb.client.MongoClient
import com.mongodb.client.MongoClients

object DataBaseConnection {

    fun getClient(): MongoClient {
        val clusterId = ""//seu-cluster-id
        val databaseName = ""//seu-nome-de-banco-de-dados
        val username = ""//seu-nome-de-usuário
        val password = ""//sua-senha

        val credential = MongoCredential.createCredential(username, databaseName, password.toCharArray())

        val serverAddress = ServerAddress("$clusterId.mongodb.net")

        val settings = MongoClientSettings.builder()
            .applyToClusterSettings { it.hosts(listOf(serverAddress)) }
            .credential(credential)
            .build()

        return MongoClients.create(settings)
    }


}