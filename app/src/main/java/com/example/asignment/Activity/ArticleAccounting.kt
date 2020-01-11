package com.example.asignment.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.asignment.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_artivle_accunting.*

class ArticleAccounting : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_artivle_accunting)

        Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/asignment-d6622.appspot.com/o/image%2Faccounting-1.jpg?alt=media&token=b12dfb2e-4331-46fa-b3ac-e6d1fbad8770").into(displayArticleImage)

    }
}
