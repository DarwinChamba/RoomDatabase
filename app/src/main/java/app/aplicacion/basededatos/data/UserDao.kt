package app.aplicacion.basededatos.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)

    suspend fun insertUser(user: User)

    @Delete
    suspend fun deleteUser(user:User)

    @Update

    suspend fun updateUser(user:User)

    @Query("select * from userTable")
    fun getAllUser():LiveData<User>
}