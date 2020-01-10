package com.example.asignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView

class MFragmentActivity : AppCompatActivity() {

    lateinit var videoFragment : MenuVideo
    lateinit var articleFragment : MenuArticle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mfragment)


        val bottomNavigation : BottomNavigationView = findViewById(R.id.bottomNavigation)

        videoFragment= MenuVideo()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frameLayout,videoFragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()

        bottomNavigation.setOnNavigationItemSelectedListener { item ->

            when (item.itemId) {

                R.id.video -> {
                    videoFragment= MenuVideo()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frameLayout,videoFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }

                R.id.article -> {
                    articleFragment= MenuArticle()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frameLayout,articleFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }
            }

            true
        }
    }
}
