package com.example.renzo_steve_medina_seccioncurso

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.renzo_steve_medina_seccioncurso.databinding.ActivityListBinding


class ListActivity : AppCompatActivity() {
    private lateinit var listBinding: ActivityListBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        listBinding = ActivityListBinding.inflate(layoutInflater)
        setContentView(listBinding.root)

        val setName = intent.getStringExtra("user")
        listBinding.tvWelUser.text = setName

        listBinding.btOff.setOnClickListener {
            logOut()
            Toast.makeText(this, "Cerrando sesión", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


    }

    private fun logOut(){
        val user = getSharedPreferences("miApp", Context.MODE_PRIVATE)
        val editor = user.edit()
        editor.putString("active", "false")
        editor.apply()
    }
}