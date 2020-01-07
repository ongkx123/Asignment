package com.example.asignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_login.*

class Login : AppCompatActivity() {

    lateinit var ref: DatabaseReference
    lateinit var userName: String
    lateinit var password: String
    private var textUserName: TextInputLayout? = null
    private var textPassword: TextInputLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        textUserName = findViewById(R.id.textInputUserName)
        textPassword = findViewById(R.id.textInputPassword)

        buttonRegister.setOnClickListener {
            val intent = Intent(applicationContext, SignUp_From::class.java)
            startActivity(intent)
        }

        buttonLogin.setOnClickListener {
           login()
        }
    }

    private fun login(){
        
    }
}
