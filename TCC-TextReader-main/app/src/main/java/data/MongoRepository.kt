package data

import io.realm.kotlin.types.ObjectId
import kotlinx.coroutines.flow.Flow
import model.User
import org.mongodb.kbson.BsonObjectId

interface MongoRepository {

    fun getData(): Flow<List<User>>
    fun filterData(name:String):Flow<List<User>>
    suspend fun insertUser(user: User)
    suspend fun deleteUser(id: BsonObjectId)
    suspend fun updateUser(user: User)



}