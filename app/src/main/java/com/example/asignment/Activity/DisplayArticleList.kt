package com.example.asignment.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.asignment.Class.Article
import com.example.asignment.Class.Video
import com.example.asignment.R
import com.example.asignment.adapter.ArticleListAdapter
import com.example.asignment.adapter.VideoListAdapter
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class DisplayArticleList : AppCompatActivity() {
    private val db = FirebaseDatabase.getInstance()
    private val profile = db.getReference("article")
    private var articleList : MutableList<Article> = mutableListOf<Article>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_image_list)

        retrieveData()
    }

    private fun retrieveData() {
        val recyclerView = findViewById<RecyclerView>(R.id.articleRecycleView)
        val adapter = ArticleListAdapter(this@DisplayArticleList)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this@DisplayArticleList, LinearLayoutManager.VERTICAL,false) as RecyclerView.LayoutManager?


        profile.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                var description:String
                var title:String
                var type:String
                var image:String

                for(i: DataSnapshot in dataSnapshot.children.iterator()){
                    description = i.child("description").value.toString()
                    title = i.child("title").value.toString()
                    image = i.child("image").value.toString()
                    type = i.child("type").value.toString()

                    articleList.add(Article(title,description,image,type))

                }

                adapter.setArticleList(articleList)
            }
            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@DisplayArticleList,"Error retrieve data from database", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
