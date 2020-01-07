package com.example.asignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.FirebaseDatabase
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
            //val intent = Intent(applicationContext,Menu::class.java)
            //startActivity(intent)

            login()
        }
    }

    private fun login(){
        var user:User
        val ref = FirebaseDatabase.getInstance().getReference("User")
        fun onDataChange(dataSnapshot: DataSnapshot){
            user = dataSnapshot.getValue() as User
            //Toast.makeText(applicationContext,user,Toast.LENGTH_SHORT).show()
        }
    }
}
