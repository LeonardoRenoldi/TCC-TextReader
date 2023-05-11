package databaseUtils

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import data.MongoRepository
import data.MongoRepositoryImpl
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import model.User
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Singleton
    @Provides
    fun providesRealm(): Realm{
        val config = RealmConfiguration.Builder(
            schema = setOf(
                User::class
            )
        )
            .compactOnLaunch()
 //           .initialData()
            .build()
        return Realm.open(config)
    }

    @Singleton
    @Provides
    fun providesMongoRepository(realm: Realm): MongoRepositoryImpl {
        return MongoRepositoryImpl(realm = realm)
    }
}