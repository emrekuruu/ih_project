package com.example.letslearnactivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.bottomnavigation.BottomNavigationView

class SixthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sixth)

        val bottomView  : BottomNavigationView = findViewById(R.id.Nav_View)
        val first = FirstFragment()
        val second = SecondFragment()
        val third = ThirdFragment()

        setCurrentFragment(first)

        bottomView.setOnNavigationItemSelectedListener{
            when(it.itemId){
                R.id.home -> setCurrentFragment(first)
                R.id.messages -> setCurrentFragment(second)
                R.id.profile -> setCurrentFragment(third)
                R.id.next ->{
                    Intent(this,SeventhActivity::class.java).also{startActivity(it)}
                }
            }
            true
        }

        bottomView.getOrCreateBadge(R.id.messages).apply {
            number = 10
            isVisible = true
        }
    }


    private fun setCurrentFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.bottomNavigationFragment  ,fragment)
            commit()
        }
    }
}