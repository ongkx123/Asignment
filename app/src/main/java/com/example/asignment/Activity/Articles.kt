package com.example.asignment.Activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.asignment.R
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_artivle_accunting.*
import kotlinx.android.synthetic.main.activity_artivle_accunting.bottomNavigationView

class Articles : AppCompatActivity() {
    private val db = FirebaseDatabase.getInstance()
    private val profile = db.getReference("article")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_artivle_accunting)

        profile.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@Articles, "Error", Toast.LENGTH_SHORT).show()
            }

            val sharedPreferences = getSharedPreferences("Article", Context.MODE_PRIVATE)
            val article = sharedPreferences.getString("Article","")

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                var type:String
                var url:String

                    for (i: DataSnapshot in dataSnapshot.children.iterator()) {
                        type = i.child("type").value.toString()

                        if(type == article){
                            url = i.child("image").value.toString()

                            Picasso.get().load(url).into(displayArticleImage)
                            articleDescription.text = i.child("description").value.toString()

                        }
                        else if(type == article){
                            url = i.child("image").value.toString()

                            Picasso.get().load(url).into(displayArticleImage)
                            articleDescription.text = i.child("description").value.toString()

                        }
                        else if(type == article){
                            url = i.child("image").value.toString()

                            Picasso.get().load(url).into(displayArticleImage)
                            articleDescription.text = i.child("description").value.toString()

                        }
                        else if(type == article){
                            url = i.child("image").value.toString()

                            Picasso.get().load(url).into(displayArticleImage)
                            articleDescription.text = i.child("description").value.toString()

                        }
                        else if(type == article){
                            url = i.child("image").value.toString()

                            Picasso.get().load(url).into(displayArticleImage)
                            articleDescription.text = i.child("description").value.toString()

                        }

                    }

            }
        })

        buttonVideo.setOnClickListener(){
            val intent = Intent(applicationContext,VideoAccounting::class.java)
            startActivity(intent)
        }
        buttonTest.setOnClickListener(){
            val intent = Intent(applicationContext,testAccounting::class.java)
            startActivity(intent)
        }

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigationHome ->{
                    val intent = Intent(applicationContext,displayImages::class.java)
                    startActivity(intent)
                }

                R.id.navigationMenu ->{
                    val intent = Intent(applicationContext,displayImages::class.java)
                    startActivity(intent)
                }
                R.id.navigationLove ->{
                    val intent = Intent(applicationContext,ListMenu::class.java)
                    startActivity(intent)

                }
            }
            false
        }
    }
}
