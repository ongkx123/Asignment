package com.example.asignment.Activity

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.asignment.R
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.mancj.materialsearchbar.MaterialSearchBar
import kotlinx.android.synthetic.main.activity_search.*


class Search : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)



        buttonSignIn.setOnClickListener(){
            val intent = Intent(applicationContext, Login::class.java)
            startActivity(intent)
        }
        buttonCreate.setOnClickListener(){
            val intent = Intent(applicationContext, SignUp_From::class.java)
            startActivity(intent)
        }
    }

}
