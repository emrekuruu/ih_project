package com.example.letslearnactivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class EightActivity : AppCompatActivity() {

    lateinit var toggle : ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eight)

        val nav  = findViewById<DrawerLayout>(R.id.drawerLayout)

        toggle = ActionBarDrawerToggle(this,nav,R.string.open,R.string.close)
        nav.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val navView : NavigationView = findViewById(R.id.drawerNavView)
        navView.setNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.drawerID1 -> Toast.makeText(this,"You Clicked Item 1",Toast.LENGTH_SHORT).show()
                R.id.drawerID2 -> Toast.makeText(this,"You Clicked Item 2",Toast.LENGTH_SHORT).show()
                R.id.drawerID3 -> {Intent(this,NinthActivity::class.java).also { startActivity(it) }}
            }
            true
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){return true}
        return super.onOptionsItemSelected(item)
    }
}