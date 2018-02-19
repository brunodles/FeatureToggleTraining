package com.brunodles.workshop.featuretoggle

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem

class MainActivity : AppCompatActivity() {

    val dashboard: DashboardFragment by lazy { DashboardFragment() }
    val list: ListFragment by lazy { ListFragment() }
    val about: AboutFragment by lazy { AboutFragment() }

    lateinit var bottomNavigation: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNavigation = findViewById(R.id.bottom_navigation)
        bottomNavigation.setOnNavigationItemSelectedListener(this::onItemSelected)
        showOnContent(dashboard)
        if (false) // featureToggle: FLAG_HIDE_ABOUT
            bottomNavigation.menu.removeItem(R.id.about)
    }

    fun onItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.dashboard -> showOnContent(dashboard)
            R.id.list -> showOnContent(list)
            R.id.about -> showOnContent(about)
            else -> showOnContent(dashboard)
        }
    }

    private fun showOnContent(fragment: Fragment): Boolean {
        supportFragmentManager.beginTransaction()
                .replace(R.id.container, fragment)
                .commit()
        return true
    }
}
