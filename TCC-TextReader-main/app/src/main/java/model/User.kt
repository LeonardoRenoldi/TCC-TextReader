package model

import io.realm.kotlin.types.ObjectId
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey


class User(): RealmObject {

 @PrimaryKey
 var id:ObjectId = ObjectId.create()
 var name: String = ""

 var email: String = ""
 var senha: String = ""

 }



