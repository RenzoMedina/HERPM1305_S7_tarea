package com.example.renzo_steve_medina_seccioncurso

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.example.renzo_steve_medina_seccioncurso.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var userEd: EditText?=null
    private var password: EditText?=null
    private lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        setTheme(R.style.Base_Theme_Renzo_steve_medina_seccioncurso)
        Thread.sleep(1500)

        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)


        userEd= viewBinding.etUser
        password = viewBinding.etPass
        viewBinding.btSignIn.setOnClickListener {
            signIn()
        }
        viewBinding.btSignUp.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
        validateData()


    }

    private fun signIn(){
        val userpref = getSharedPreferences("miApp", Context.MODE_PRIVATE)
        val user = userpref.getString("user", "")
        val pass = userpref.getString("pass","")

        val validateUser = userEd?.text.toString().trim()
        val validatePass = password?.text.toString()
        if(validateUser.isNotEmpty() && validatePass.isNotEmpty()){
            if (pass == validatePass && user == validateUser){
                Toast.makeText(this, "Exito",Toast.LENGTH_SHORT ).show()
                userpref.edit().putString("active","true").apply()
                listDays(userEd?.text.toString())
            }
            else{
                Toast.makeText(this, "No son los datos correctos",Toast.LENGTH_LONG ).show()
            }
        }else{
            Toast.makeText(this, "Error los campos están vacios",Toast.LENGTH_LONG ).show()
        }

    }

    private fun validateData(){
        val userpref = getSharedPreferences("miApp", Context.MODE_PRIVATE)
        if(userpref.getString("active","") == "true"){
            Toast.makeText(this,"Se ha encontrado una sesión activa", Toast.LENGTH_LONG).show()
           listDays(userpref.getString("user","").toString())
        }
    }

    private fun listDays(user:String){
        val intent = Intent(this, ListActivity::class.java).apply {
            putExtra("user", user)
        }
        startActivity(intent)
    }


}