package com.example.roomdatabase

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        login()
    }

    private fun login() {
        val email : TextInputEditText = findViewById(R.id.email_ET_login)
        val password : TextInputEditText = findViewById(R.id.password_ET_login)
        val signInButton = findViewById<MaterialButton>(R.id.sign_in_btn)
        
        signInButton.setOnClickListener { 
            if (email.text.isNullOrEmpty() || password.text.isNullOrEmpty()){
                Toast.makeText(this, "Email or Password is not provided", Toast.LENGTH_LONG).show()
            } else if(email.text.toString() == "maurice@gmail.com" && password.text.toString() == "1905") {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)

            }else{
                Toast.makeText(this, "Wrong email or password", Toast.LENGTH_LONG).show()
            }
        }
    }
}