package app.aplicacion.basededatos.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "userTable")
data class User (
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val nombre:String,
    val edad:Int
        )