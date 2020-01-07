package com.example.asignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*

class Login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        buttonRegister.setOnClickListener{
            val intent = Intent(applicationContext,SignUp_From::class.java)
            startActivity(intent)
        }

        buttonLogin.setOnClickListener{
            val intent = Intent(applicationContext,FragmentActivity::class.java)
            startActivity(intent)
        }
    }
}
