package com.example.imdbapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomActivity : AppCompatActivity() {
    private val onNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    replaceFragment(com.example.imdbapp.HomeFragment())
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_dashboard -> {
                    replaceFragment(SearchFragment())
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_notifications -> {
                    replaceFragment(com.example.imdbapp.ProfileFragment())
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.homactivity)
        val navView: BottomNavigationView = findViewById(R.id.bottom_navigation)
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        if (savedInstanceState == null) {
            replaceFragment(HomeFragment())
        }
    }
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .commit()
    }
}