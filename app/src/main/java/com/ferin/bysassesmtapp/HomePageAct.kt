package com.ferin.bysassesmtapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class HomePageAct : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle
    lateinit var drawerLayoutVar: DrawerLayout
    lateinit var navViewVar: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        drawerLayoutVar = findViewById(R.id.drawerLayout)
        navViewVar = findViewById(R.id.nav_view)

        toggle = ActionBarDrawerToggle(this,drawerLayoutVar,R.string.open,R.string.close)
        drawerLayoutVar.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navViewVar.setNavigationItemSelectedListener{

            when(it.itemId){
                R.id.nav_home -> Toast.makeText(applicationContext,"Home Clicked",Toast.LENGTH_SHORT).show()
                R.id.nav_notification -> Toast.makeText(applicationContext,"Notification Clicked",Toast.LENGTH_SHORT).show()
                R.id.nav_settings -> Toast.makeText(applicationContext,"Settings Clicked",Toast.LENGTH_SHORT).show()
                R.id.nav_about -> Toast.makeText(applicationContext,"About Clicked",Toast.LENGTH_SHORT).show()
                R.id.nav_share -> Toast.makeText(applicationContext,"Share Clicked",Toast.LENGTH_SHORT).show()
            }

            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item))
        {
            return true
        }
        else{
            return super.onOptionsItemSelected(item)

        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.homepage_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    fun signOut(item: MenuItem) {
        val goToLoginPage = Intent(this,MainActivity::class.java)
        startActivity(goToLoginPage)
    }
}