package app.aplicacion.basededatos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import app.aplicacion.basededatos.data.User
import app.aplicacion.basededatos.data.UserViewModel
import app.aplicacion.basededatos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var model:UserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        model=ViewModelProvider(this).get(UserViewModel::class.java)


        binding.btnAdd.setOnClickListener {
            insertUser()
        }
        binding.btngetUser.setOnClickListener {
            getUser()
        }

    }
    private fun insertUser(){
        val user=User(0,"Darwin",3)
        model.insertUser(user)
        Toast.makeText(this,"registro insertado con exito",Toast.LENGTH_SHORT).show()
    }

    private fun getUser(){
        model.lista.observe(this, Observer {
            println(it)
        })
    }
}