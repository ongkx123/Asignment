
package com.example.asignment.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.asignment.R
import kotlinx.android.synthetic.main.activity_list_menu.*

class ListMenu : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_menu)

        buttonArticle.setOnClickListener{
            val intent = Intent(applicationContext,DisplayArticleList::class.java)
            startActivity(intent)
        }

        buttonVideo.setOnClickListener{
            val intent = Intent(applicationContext,DisplayVideoList::class.java)
            startActivity(intent)
        }
    }
}
