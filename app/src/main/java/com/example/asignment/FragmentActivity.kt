package com.example.asignment

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_fragment.*

class FragmentActivity : AppCompatActivity() {

    lateinit var homeFragment : HomeFragment
    lateinit var menuFragment : MenuFragment
    lateinit var favouriteFragment : FavouriteFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

        val bottomNavigation : BottomNavigationView = findViewById(R.id.bottomNavigation)
/*
        homeFragment= HomeFragment()
        supportFragmentManager
            .beginTransaction()
            .replace(container.id,homeFragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()
*/

        val fragment = HomeFragment()
        val fragmentManager = this.supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(container.id,fragment,null)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()

        bottomNavigation.setOnNavigationItemSelectedListener { item ->

            when (item.itemId) {

                R.id.navigationHome -> {
                    val fragment = HomeFragment()
                    val fragmentManager = this.supportFragmentManager
                    val fragmentTransaction = fragmentManager.beginTransaction()
                    fragmentTransaction.replace(container.id,fragment,null)
                    fragmentTransaction.addToBackStack(null)
                    fragmentTransaction.commit()
                }

                R.id.navigationMenu -> {
                    val fragment= MenuFragment()
                    val fragmentManager = this.supportFragmentManager
                    val fragmentTransaction = fragmentManager.beginTransaction()
                    fragmentTransaction.replace(container.id,fragment,null)
                    fragmentTransaction.addToBackStack(null)
                    fragmentTransaction.commit()
                }

                R.id.navigationList -> {
            val fragment= FavouriteFragment()
            val fragmentManager = this.supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(container.id,fragment,null)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
                }

        }

            true
        }
    }
}
