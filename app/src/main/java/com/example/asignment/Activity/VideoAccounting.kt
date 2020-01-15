package com.example.asignment.Activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.asignment.R
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_accounting.*
import kotlinx.android.synthetic.main.activity_accounting.bottomNavigationView


class VideoAccounting : AppCompatActivity() {
    private val db = FirebaseDatabase.getInstance()
    private val profile = db.getReference("video")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_accounting)

        article()

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigationMenu -> {
                    val intent = Intent(applicationContext, displayImages::class.java)
                    startActivity(intent)
                }

                R.id.navigationMenu -> {
                    val intent = Intent(applicationContext, displayImages::class.java)
                    startActivity(intent)
                }
                R.id.navigationList ->{
                    val intent = Intent(applicationContext,ListMenu::class.java)
                    startActivity(intent)

                }
            }
            false
        }
    }

    private fun article() {
        profile.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@VideoAccounting, "Error", Toast.LENGTH_SHORT).show()
            }

            val sharedPreferences = getSharedPreferences("Article", Context.MODE_PRIVATE)
            val article = sharedPreferences.getString("Article","")

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                var type:String
                var url:String

                for (i: DataSnapshot in dataSnapshot.children.iterator()) {
                    type = i.child("type").value.toString()

                    if(type == article){
                        url = i.child("video").value.toString()

                        webView.loadUrl(url)
                        videoDescription.text = i.child("description").value.toString()

                    }
                    else if(type == article){
                        url = i.child("video").value.toString()

                        webView.loadUrl(url)
                        videoDescription.text = i.child("description").value.toString()

                    }
                    else if(type == article){
                        url = i.child("video").value.toString()

                        webView.loadUrl(url)
                        videoDescription.text = i.child("description").value.toString()

                    }
                    else if(type == article){
                        url = i.child("video").value.toString()

                        webView.loadUrl(url)
                        videoDescription.text = i.child("description").value.toString()

                    }
                    else if(type == article){
                        url = i.child("video").value.toString()

                        webView.loadUrl(url)
                        videoDescription.text = i.child("description").value.toString()

                    }

                }

            }
        })
    }
}
