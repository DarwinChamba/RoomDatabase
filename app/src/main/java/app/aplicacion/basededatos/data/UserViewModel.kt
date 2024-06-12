package app.aplicacion.basededatos.data

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class UserViewModel(application: Application):AndroidViewModel(application) {

    val lista:LiveData<User>
    private val repository:Repository
    init {
        val dao=UserDatabase.invoke(application).getUserDatabase()
        repository=Repository(dao)
        lista=repository.getAllUser()
    }

    fun insertUser(user: User){
        viewModelScope.launch {
            repository.insertUser(user)
        }
    }
}