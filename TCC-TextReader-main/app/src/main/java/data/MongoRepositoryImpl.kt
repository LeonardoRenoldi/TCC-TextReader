package data

import io.realm.kotlin.Realm
import io.realm.kotlin.ext.query
import io.realm.kotlin.query.RealmResults
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import model.User
import org.mongodb.kbson.BsonObjectId

class MongoRepositoryImpl(val realm:Realm):MongoRepository {

    override fun getData(): Flow<RealmResults<User>> {

        return realm.query<User>().asFlow().map { it.list }
    }

    override fun filterData(name: String): Flow<List<User>> {
      //  return realm.query<Person>(query = "name CONTAINS[c] $0", name).asFlow().map { it.list }
        return realm.query<User>(query = "name CONTAIN[c] $0", name).asFlow().map { it.list }
    }

    override suspend fun insertUser(user: User) {
       // realm.write { copyToRealm(person) }
        realm.write { copyToRealm(user) }
    }

    override suspend fun deleteUser(id: BsonObjectId) {
        TODO("Not yet implemented")
    }



    override suspend fun updateUser(user: User) {
        realm.write {
            val queriedUser = query<User>(query = "_id == 0$", user.id).first().find()
            queriedUser?.name = user.name
        }
    }

}