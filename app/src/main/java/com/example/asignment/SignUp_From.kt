package com.example.asignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_login.buttonRegister
import java.util.regex.Pattern

class SignUp_From : AppCompatActivity() {

    private var textFullName : TextInputLayout? = null
    private var textUserName : TextInputLayout? = null
    private var textAge : TextInputLayout? = null
    private var textEmail : TextInputLayout? = null
    private var textPassword : TextInputLayout? = null
    private var textConfirmPassword : TextInputLayout? = null
   // private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up__from)

        textFullName =findViewById(R.id.textInputFullName)
        textUserName =findViewById(R.id.textInputUserName)
        textAge =findViewById(R.id.textInputAge)
        textEmail =findViewById(R.id.textInputEmail)
        textPassword =findViewById(R.id.textInputPassword)
        textConfirmPassword =findViewById(R.id.textInputConfirmPassword)



        buttonRegister.setOnClickListener{
            btnRegister()
        }
    }

    private fun validateFullName():Boolean{

        val fullName = textFullName!!.editText!!.text.toString().trim()

        if (fullName.isEmpty()){
            textFullName!!.error = "Field can't be empty"
            return false
        }
        else{
            textFullName!!.error = null
            return true
        }
    }

    private fun validateUserName():Boolean{

        val userName = textUserName!!.editText!!.text.toString().trim()

        if (userName.isEmpty()){
            textUserName!!.error = "Field can't be empty"
            return false
        }
        else if (userName.length >= 20 ){
            textUserName!!.error = "Username must within 20 word"
            return false
        }
        else{
            textUserName!!.error = null
            return true
        }
    }

    private fun validateAge():Boolean{

        val age = textAge!!.editText!!.text.toString().trim()

        if (age.isEmpty()){
            textAge!!.error = "Field can't be empty"
            return false
        }
        else{
            textAge!!.error = null
            return true
        }
    }

    private fun validateEmail():Boolean{

        val email = textEmail!!.editText!!.text.toString().trim()

        if (email.isEmpty()){
            textEmail!!.error = "Field can't be empty"
            return false
        }
        else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            textEmail!!.error = "Invalid Email"
            return false
        }
        else{
            textEmail!!.error = null
            return true
        }
    }

    private fun validatePassword():Boolean{

        val password = textPassword!!.editText!!.text.toString().trim()

        if (password.isEmpty()){
            textPassword!!.error = "Field can't be empty"
            return false
        }
        else if(!PASSWORD_PATTERN.matcher(password).matches()){
            textPassword!!.error = "Invalid Password"
            return false
        }
        else{
            textPassword!!.error = null
            return true
        }
    }

    private fun validateConfirmPassword():Boolean{

        val confirmPassword = textConfirmPassword!!.editText!!.text.toString().trim()
        val password = textPassword!!.editText!!.text.toString().trim()

        if (confirmPassword.isEmpty()){
            textConfirmPassword!!.error = "Field can't be empty"
            return false
        }
        else if(confirmPassword != password){
            textConfirmPassword!!.error = "Password not same"
            return false
        }
        else{
            textConfirmPassword!!.error = null
            return true
        }
    }

    private fun btnRegister(){

        if(!validateFullName() or  !validateUserName() or  !validateAge() or  !validateEmail() or  !validatePassword() or  !validateConfirmPassword()){

            Toast.makeText(applicationContext,"Hello",Toast.LENGTH_SHORT).show()
        }
        else{
            val fullName = textFullName!!.editText!!.text.toString().trim()
            val userName = textUserName!!.editText!!.text.toString().trim()
            val age = textAge!!.editText!!.text.toString().trim()
            val email = textEmail!!.editText!!.text.toString().trim()
            val password = textPassword!!.editText!!.text.toString().trim()

            val ref = FirebaseDatabase.getInstance().getReference("user")
            val userID = ref.push().key.toString()

            val user = User(userID,fullName,userName,age,email,password)

            ref.child(userID).child("PEPE LEE").setValue(user)
        }
    }

    companion object {

        private val EMAIL_PATTERN = Pattern.compile("[a-zA-Z0-9\\+\\_\\%\\-\\+]{1,256}" +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                "(" +
                "\\." +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                ")+"
        )

        private val PASSWORD_PATTERN = Pattern.compile("^" +
                "(?=.*[0-9])" +
                "(?=.*[a-z])" +
                "(?=.*[A-Z])" +
                ".{8,}" +
                "$")
    }

}
