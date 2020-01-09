package com.example.asignment

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_reward.*
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_display_images.*


class reward : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reward)

        val sharedPreferences=getSharedPreferences("correctAns",Context.MODE_PRIVATE)
       val crtAnswer=sharedPreferences.getInt("correctAns",0)

        val answer =crtAnswer.toString()
        if(crtAnswer>3){

            imageView3.setImageResource(R.drawable.award)
            textViewComment.text="Congratulations!! You have scored" + answer + "correct"


        }
        else{
            imageView3.setImageResource(R.drawable.download)
            textViewComment.text="You got" + answer + "correct,Try harder next time"
        }
    }
}
