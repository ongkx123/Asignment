package com.example.asignment.Activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.asignment.Class.Video
import kotlinx.android.synthetic.main.activity_reward.*
import com.example.asignment.R
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class reward : AppCompatActivity() {
    private val db = FirebaseDatabase.getInstance()
    private val profile = db.getReference("user")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reward)

        profile.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@reward, "Error", Toast.LENGTH_SHORT).show()
            }

            val sharedPreferences = getSharedPreferences("correctAns", Context.MODE_PRIVATE)
            val crtAnswer = sharedPreferences.getInt("correctAns", 0)
            val sharedPreferenceUser = getSharedPreferences("NAME", Context.MODE_PRIVATE)
            val sharedName = sharedPreferenceUser.getString("NAME", "")

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                var name: String
                val userID = profile.push().key.toString()
                val answer = crtAnswer.toString()

                if (crtAnswer > 3) {

                    for (i: DataSnapshot in dataSnapshot.children.iterator()) {

                        name = i.child("userName").value.toString()

                        if (sharedName == name) {
                            profile.child("marks").setValue(crtAnswer)
                        }
                    }
                    imageViewReward.setImageResource(R.drawable.award)
                    textViewComment.text = "Results: " + answer + "Correct"
                    textView.text = "Congratulations!! You get an award"
                } else {
                    imageViewReward.setImageResource(R.drawable.download)
                    textViewComment.text = "Results: " + answer + "Correct"
                    textView.text = "Try harder next time"
                }
            }
        })
    }

}
