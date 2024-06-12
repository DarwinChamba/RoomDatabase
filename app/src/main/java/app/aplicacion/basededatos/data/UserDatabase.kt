package app.aplicacion.basededatos.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import java.util.concurrent.locks.Lock

@Database(entities = [User::class], version = 1 , exportSchema = false)
abstract  class UserDatabase:RoomDatabase() {
    abstract fun getUserDatabase():UserDao

    companion object{
        @Volatile
        private var instance:UserDatabase?=null
        private val LOCK = Any()

        operator fun invoke(context: Context)= instance ?: synchronized(LOCK) {
            instance?: createDatabase(context).also {instance=it}
        }

        private fun createDatabase(context: Context)=
            Room.databaseBuilder(context,UserDatabase::class.java,
            "userDatabase").build()

    }
}