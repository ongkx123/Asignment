package com.example.asignment.Activity

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.asignment.Class.Video
import com.example.asignment.R
import com.example.asignment.adapter.VideoListAdapter
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class DisplayVideoList : AppCompatActivity() {

    private val db = FirebaseDatabase.getInstance()
    private val profile = db.getReference("video")
    private var videoList : MutableList<Video> = mutableListOf<Video>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_video_list)

        retrieveData()
    }

    private fun retrieveData() {
        val recyclerView = findViewById<RecyclerView>(R.id.recycleViewVideo)
        val adapter = VideoListAdapter(this@DisplayVideoList)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this@DisplayVideoList, LinearLayoutManager.VERTICAL,false) as RecyclerView.LayoutManager?


        profile.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                var description:String
                var title:String
                var type:String
                var video:String

                for(i: DataSnapshot in dataSnapshot.children.iterator()){
                    description = i.child("description").value.toString()
                    title = i.child("title").value.toString()
                    type = i.child("type").value.toString()
                    video = i.child("video").value.toString()

                    videoList.add(Video(title,description,type,video))

                }

                adapter.setVideoList(videoList)
            }
            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@DisplayVideoList,"Error retrieve data from database", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
