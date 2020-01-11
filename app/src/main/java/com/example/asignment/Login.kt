package com.example.asignment

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_login.*

class Login : AppCompatActivity() {
    private val db = FirebaseDatabase.getInstance()
    private val profile = db.getReference("user")
    private var textUserName : TextInputLayout? = null
    private var textPassword : TextInputLayout? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        //val sharedPreferences: SharedPreferences = this.getSharedPreferences("PREFERENCE_NAME", 0)


        textUserName =findViewById(R.id.textInputUserName)
        textPassword =findViewById(R.id.textInputPassword)
        buttonRegister.setOnClickListener{
            val intent = Intent(applicationContext,SignUp_From::class.java)
            startActivity(intent)
        }

        buttonLogin.setOnClickListener{
            login()

        }

    }

    private fun login(){
            profile.addValueEventListener(object : ValueEventListener{
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    val sharedPreferences: SharedPreferences = getSharedPreferences("PREFERENCE_NAME", 0)
                    var output = ""
                    val user = textUserName!!.editText!!.text.toString()
                    val passwordText = textPassword!!.editText!!.text.toString()

                    for(i: DataSnapshot in dataSnapshot.children.iterator()){
                        output = output.plus(String.format("Name : %s", i.child("fullName").value))
                        val name = i.child("userName").value
                        val password = i.child("password").value

                        if(user == name && password == passwordText){
                            Toast.makeText(this@Login,"Successfull Login",Toast.LENGTH_SHORT).show()

                            var editor = sharedPreferences.edit()
                            editor.putString("NAME",name)
                            editor.commit()
                            val pName = "Welcome back " + sharedPreferences.getString("NAME","")

                            Toast.makeText(this@Login, pName, Toast.LENGTH_SHORT).show()

                            val intent = Intent(applicationContext,FragmentActivity::class.java)
                            startActivity(intent)
                        }
                    }

                }
                override fun onCancelled(error: DatabaseError) {
                    Toast.makeText(this@Login,"Error",Toast.LENGTH_SHORT).show()
                }
            })
        }

}

