
package com.example.asignment.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.asignment.R
import kotlinx.android.synthetic.main.activity_artivle_accunting.*
import kotlinx.android.synthetic.main.activity_list_menu.*
import kotlinx.android.synthetic.main.activity_list_menu.buttonVideo

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
                R.id.navigationList ->{
                    val intent = Intent(applicationContext,ListMenu::class.java)
                    startActivity(intent)

                }
            }
            false
        }
    }
}
