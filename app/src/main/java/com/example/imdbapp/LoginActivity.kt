package com.example.imdbapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.loginactivity)
        val login: Button = findViewById(R.id.login)
        login.setOnClickListener {
            initScreen(HomActivity::class.java)
        }
        val textRegister: TextView = findViewById(R.id.linkRegistro)
        textRegister.setOnClickListener {
            initScreen(RegisterActivity::class.java)
        }
    }
    private fun initScreen(activity: Class<*>){
        val intent = Intent(this, activity)
        startActivity(intent)
    }
}