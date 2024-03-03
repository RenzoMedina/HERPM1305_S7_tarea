package com.example.renzo_steve_medina_seccioncurso

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.example.renzo_steve_medina_seccioncurso.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var registerBinding: ActivityRegisterBinding
    private var userEd:EditText?=null
    private var pass:EditText?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registerBinding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(registerBinding.root)
        userEd = registerBinding.etUsr
        pass = registerBinding.etPassword

        registerBinding.btSave.setOnClickListener {
            if(!saveRegister()){
                Toast.makeText(this, "Error no se ha podido guardar registro",Toast.LENGTH_LONG).show()
            }
            userEd?.setText("")
            pass?.setText("")
            Toast.makeText(this, "Registro guardado con éxito",Toast.LENGTH_LONG).show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }

    private fun saveRegister():Boolean {
        val user = getSharedPreferences("miApp", Context.MODE_PRIVATE)
        val editor = user.edit()
        editor.putString("pass", pass?.text.toString())
        editor.putString("user", userEd?.text.toString())
        editor.putString("active", "false")
        editor.apply()
        return true
    }


}