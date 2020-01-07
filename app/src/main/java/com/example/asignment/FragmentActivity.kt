package com.example.asignment

import android.os.Bundle
import android.view.Menu
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController

class FragmentActivity : AppCompatActivity() {

    lateinit var homeFragment : HomeFragment
    lateinit var menuFragment : MenuFragment
    lateinit var favouriteFragment : FavouriteFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

        val bottomNavigation : BottomNavigationView = findViewById(R.id.bottomNavigation)

        homeFragment= HomeFragment()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frameLayout,homeFragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()

        bottomNavigation.setOnNavigationItemSelectedListener { item ->

            when (item.itemId) {

                R.id.navigationHome -> {
                    homeFragment= HomeFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frameLayout,homeFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }

                R.id.navigationMenu -> {
                    menuFragment= MenuFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frameLayout,menuFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }

                R.id.navigationLove -> {
                    favouriteFragment= FavouriteFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frameLayout,favouriteFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }
            }

            true
        }
    }
}
