package screen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import data.MongoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import model.User
import org.mongodb.kbson.ObjectId
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: MongoRepository
):ViewModel() {

    var name = mutableStateOf("")
    var objectId = mutableStateOf("")
    var filtered = mutableStateOf(false)
    var data = mutableStateOf(emptyList<User>())

    init {
      viewModelScope.launch {
          repository.getData().collect{
              data.value= it
          }
      }
    }

    fun updateName(name: String) {
        this.name.value = name
    }

    fun updateObjectId(id: String) {
        this.objectId.value = id
    }

    fun insertPerson() {
        viewModelScope.launch(Dispatchers.IO) {
            if (name.value.isNotEmpty()  ) {
                repository.insertUser(user = User().apply {
                    name = this@HomeViewModel.name.value
                })
            }
        }
    }



    fun deletePerson(){
        viewModelScope.launch {
            if (objectId.value.isNotEmpty()){
                repository.deleteUser(id = ObjectId(hexString = objectId.value))
            }
        }
    }

    fun filterData(){
        viewModelScope.launch(Dispatchers.IO){
            if (filtered.value){
                repository.getData().collect{
                    filtered.value = false
                    name.value = ""
                    data.value = it
                }
            } else{
                repository.filterData(name = name.value).collect{
                    filtered.value = true
                    data.value = it
                }
            }
        }
    }

}