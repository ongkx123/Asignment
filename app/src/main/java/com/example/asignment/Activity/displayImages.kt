package com.example.asignment.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.asignment.R
import kotlinx.android.synthetic.main.activity_display_images.*

class displayImages : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_images)
        displayImage()
    }
        fun displayImage() {
            val url: String =
                "https://firebasestorage.googleapis.com/v0/b/asignment-d6622.appspot.com/o/image%2Faccounting.jpg?alt=media&token=d329da4b-c8bb-48fb-88fc-74f7490fed79"
            Glide.with(applicationContext).load(url).into(imageView)

            val url2: String =
                "https://firebasestorage.googleapis.com/v0/b/asignment-d6622.appspot.com/o/image%2Fagriculture.jpg?alt=media&token=d32513f8-04d8-4f67-9005-95ef16599bc6"
            Glide.with(applicationContext).load(url2).into(imageView2)

            val url3: String =
                "https://firebasestorage.googleapis.com/v0/b/asignment-d6622.appspot.com/o/image%2Fbusiness.jpg?alt=media&token=22aeb663-24a8-4103-87f7-bae6e45ae847"
            Glide.with(applicationContext).load(url3).into(imageView3)

            val url4: String =
                "https://firebasestorage.googleapis.com/v0/b/asignment-d6622.appspot.com/o/image%2Fdoctor.jpg?alt=media&token=41d35e04-aff4-43b3-9220-cb9818430d49"
            Glide.with(applicationContext).load(url4).into(imageView4)

            val url5: String =
                "https://firebasestorage.googleapis.com/v0/b/asignment-d6622.appspot.com/o/image%2Fmechanic.png?alt=media&token=6a883543-5268-4254-94fb-df5cc4a23f5e"
            Glide.with(applicationContext).load(url5).into(imageView5)

            val url6: String =
                "https://firebasestorage.googleapis.com/v0/b/asignment-d6622.appspot.com/o/image%2Fsoftware.jpg?alt=media&token=4e228a52-7aee-44af-8e56-1034b0ab7b36"
            Glide.with(applicationContext).load(url6).into(imageView6)

            imageView.setOnClickListener{
                val intent = Intent(applicationContext,ArticleAccounting::class.java)
                startActivity(intent)
            }
            imageView2.setOnClickListener{
                val intent = Intent(applicationContext,DisplayArticleList::class.java)
                startActivity(intent)
            }
            imageView3.setOnClickListener{
                val intent = Intent(applicationContext,DisplayArticleList::class.java)
                startActivity(intent)
            }
            imageView4.setOnClickListener{
                val intent = Intent(applicationContext,DisplayArticleList::class.java)
                startActivity(intent)
            }
            imageView5.setOnClickListener{
                val intent = Intent(applicationContext,DisplayArticleList::class.java)
                startActivity(intent)
            }
            imageView6.setOnClickListener{
                val intent = Intent(applicationContext,DisplayArticleList::class.java)
                startActivity(intent)
            }

        }
    }
