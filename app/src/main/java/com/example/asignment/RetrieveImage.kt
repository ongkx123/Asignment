package com.example.asignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class RetrieveImage : AppCompatActivity() {
    private val db = FirebaseDatabase.getInstance()
    private val profile = db.getReference("image")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrieve_image)

        retrieve()

    }

    fun retrieve(){
        profile.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
                Toast.makeText(this@RetrieveImage,"Error",Toast.LENGTH_SHORT).show()
            }

            override fun onDataChange(dataSnapshot: DataSnapshot) {

                var image:String = ""

                for(i: DataSnapshot in dataSnapshot.children.iterator()){
                    image = i.child("image").value.toString()



                }

            }

    } )
    }
}
