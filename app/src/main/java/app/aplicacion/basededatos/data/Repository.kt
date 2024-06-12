package app.aplicacion.basededatos.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Database
import androidx.room.RoomDatabase

class Repository(private val dao:UserDao) {


    suspend fun insertUser(user: User) {
        dao.insertUser(user)
    }
    fun getAllUser():LiveData<User>{
      return  dao.getAllUser()
    }
}