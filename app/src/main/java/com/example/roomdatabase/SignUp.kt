package com.example.roomdatabase

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.roomdatabase.db.ContactRespository
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class SignUp : AppCompatActivity() {
    private lateinit var contactRespository: ContactRespository
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        signUp()

    }

    private fun signUp() {
        val firstName : TextInputEditText = findViewById(R.id.firstName_ET)
        val lastName : TextInputEditText = findViewById(R.id.lastName_ET)
        val email : TextInputEditText = findViewById(R.id.email_ET)
        val password : TextInputEditText = findViewById(R.id.password_ET)
        val signUpBtn : MaterialButton  = findViewById(R.id.sign_button)

        signUpBtn.setOnClickListener {
            if (firstName.text.isNullOrEmpty() || lastName.text.isNullOrEmpty() || email.text.isNullOrEmpty() || password.text.isNullOrEmpty() ){
                Toast.makeText(this, "Please Fill all Fields", Toast.LENGTH_LONG).show()
            } else{

                val intent = Intent(this,Login::class.java)
                startActivity(intent)




            }
        }
    }
}


//                contactRespository.insertContact(NoteEntity(firstName = firstName.text.toString(),lastName = lastName.text.toString(),
//                        email =email.text.toString(), password = password.text.toString()))
//                finish()
//
